import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Train implements Runnable {
	protected int id;
	protected static int counter = 1;
	protected final int speed;
	protected int position = -1;
	protected ReentrantLock trainLock = new ReentrantLock();
	protected Condition moveTrain = trainLock.newCondition();

	Train(int id, int speed, int position) {
		this.id = counter++;
		this.speed = speed;
		this.position = position;
	}

	public void run() {

		// run the loop until the train reaches the last station
		while (position < RunMe.getRailwayList().size()) {

			moveThroughSegment();
			moveIn();
			moveOut();
		}
	}

	public void moveThroughSegment() {
		try {
			// move through track
			if (RunMe.getRailwayList().get(position) instanceof Track) {
				Thread.sleep(timeOnTrack(RunMe.getRailwayList().get(position).getLength()));
				// move through station
			} else {
				Thread.sleep(timeInStation(RunMe.getRailwayList().get(position).getLength()));
			}
		} catch (IndexOutOfBoundsException e) {
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void moveIn() {

		try {
			// lock the current thread
			trainLock.lock();
			// make the thread wait while there are still segments ahead
			if (position < RunMe.getRailwayList().size() - 1) {
				// while the next segment is full, await the signal from the lock condition
				while (RunMe.getRailwayList().get(position + 1).checkSegmentFull()) {
					System.out.println("Locked and waiting...");
					moveTrain.await();
				}

				// increase position of the train by 1
				position++;
				if (position < RunMe.getRailwayList().size()) {
					// increase current capacity of the segment the train moved onto by 1
					RunMe.getRailwayList().get(position).addCurrentCapacity();
				} else {
					// train is out of the Railway
				}

			}
		} catch (InterruptedException e) {
		}
	}

	public void moveOut() {
		try {
			RunMe.getRailwayList().get(position - 1).deductCurrentCapacity();
		} catch (IndexOutOfBoundsException e) {
		}
		moveTrain.signalAll();
		trainLock.unlock();
	}

	public int timeOnTrack(int length) {

		// multiply by 1000 to get seconds rather than ms to be used in thread
		int time = 1000 * length / speed;
		return time;
	}

	public int timeInStation(int length) {
		int time = 1000 * length / speed + 5000;
		return time;
	}

	public int getId() {
		return id;
	}

	public int getPosition() {
		return position;
	}

}
