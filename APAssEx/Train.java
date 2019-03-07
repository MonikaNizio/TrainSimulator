import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Train implements Runnable {
	protected int id;
	protected static int counter = 1;
	protected int speed;
	protected int position = -1;
	// protected Track currentTrack;
	protected ReentrantLock trainLock = new ReentrantLock();
	protected Condition moveTrain = trainLock.newCondition();

	Train(int id, int speed, int position) {
		this.id = counter++;
		this.speed = speed;
		this.position = position;
	}

	public void run() {

//		try {

			// add 1 to the current capacity of the first segment
			//RunMe.getRailwayList().get(position).setCurrentCapacity(+1);
			
			//run the loop until the train reaches the last station
			while (position <= RunMe.getRailwayList().size()) {

				moveThroughSegment();
			
				
				moveIn();

				moveOut();

			}}
	public void moveThroughSegment() {
		try {
			if (RunMe.getRailwayList().get(position) instanceof Track) {
				Thread.sleep(timeOnTrack(RunMe.getRailwayList().get(position).getLength()));
			} else {
				Thread.sleep(timeInStation(RunMe.getRailwayList().get(position).getLength()));
			}
		} catch (IndexOutOfBoundsException e) {
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void moveIn() {

		
		try {
			// Locks the current thread.
			trainLock.lock();
			if (position <= (RunMe.getRailwayList().size() - 1)) {
				if(position == (RunMe.getRailwayList().size() - 1)) {
					System.out.println("Reached last station");
				position++;}

			
		// make the thread wait while there are still segments ahead
			 if (position < RunMe.getRailwayList().size() - 1) {
			// While the next segment is full, await the signal from the lock condition
			while (RunMe.getRailwayList().get(position + 1).checkSegmentFull()) {
				System.err.println("Locked and waiting...");
				moveTrain.await();
			}
			moveTrain.signalAll();
			// increase position of the train by 1
			position++;
//			try {
				if(position < RunMe.getRailwayList().size()) {
				// increase current capacity of the segment the train moved onto by 1
				RunMe.getRailwayList().get(position).setCurrentCapacity(+1);
				}else {
					//train is out of the Railway 
				}
//			} catch (IndexOutOfBoundsException e) {
//			}
			 }
		}
		}catch(InterruptedException e) {
			
		}finally {
			trainLock.unlock();
		}
		

	}
	
	public void moveOut() {
		trainLock.lock();
		
		try {
		RunMe.getRailwayList().get(position - 1).setCurrentCapacity(-1);
		} catch (IndexOutOfBoundsException e) {
		}
		moveTrain.signalAll();
		trainLock.unlock();
		
	}

	public int timeOnTrack(int length) {

		// multiply by 1000 to get seconds rather than ms to be used in thread
		int time = 1000 * length / this.speed;
		return time;
	}

	public int timeInStation(int length) {
		int time = 1000 * length / this.speed + 5000;
		return time;
	}

	public int getId() {
		return id;
	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getSpeed() {
//		return speed;
//	}
//
//	public void setSpeed(int speed) {
//		this.speed = speed;
//	}

	public int getPosition() {
		return position;
	}
//
//	public void setPosition(int position) {
//		this.position = position;
//	}

//	public void setNext(Track next) {
//		this.next = next;
//	}
//
//	public Track getNext() {
//		return next;
//	}

}
