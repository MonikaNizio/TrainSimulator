import java.util.ArrayList;
import java.util.Random;

public class TrafficGenerator implements Runnable {

	private Random random = new Random();
	private ArrayList<Train> trainList = new ArrayList<Train>();

	public TrafficGenerator() {
	}

	@Override
	public void run() {

		try {
			while (true) {

				removeTrain();
				generateTrains();
			}
		} catch (InterruptedException e) {
		}
	}

	public void generateTrains() throws InterruptedException{
		// interval between trains 5-10 second
		int trainIntervalTime = random.nextInt(5000) + 5000;
		int trainTypeRandom = random.nextInt(2);

		Thread.sleep(trainIntervalTime);

		// generate fast or slow trains randomly
		if (trainTypeRandom == 0) {
			Train newFastTrain = new FastTrain();
			new Thread(newFastTrain).start();
			trainList.add(newFastTrain);
		} else {
			Train newSlowTrain = new SlowTrain();
			new Thread(newSlowTrain).start();
			trainList.add(newSlowTrain);
		}
	}
	public void removeTrain() {
		// remove trains from the list if they reached the end of the Railway
		for (int i = 0; i < trainList.size(); i++) {
			if (trainList.get(i).getPosition() == RunMe.getRailwayList().size() - 1) {
				trainList.remove(i);
			}
		}
	}
	
	public ArrayList<Train> getTrainList() {
		return trainList;
	}

}
