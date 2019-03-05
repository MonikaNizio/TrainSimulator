import java.util.ArrayList;
import java.util.Random;

public class TrafficGenerator implements Runnable{

	private Random random = new Random();
	private ArrayList<Train> trainList = new ArrayList<Train>();
	
	public TrafficGenerator() {
		//trainList = new ArrayList<Train>();
	}
	
	@Override
	public void run() {
				
		try {
			while(true) {
				//interval between trains 5-10 second
				int trainIntervalTime = random.nextInt(5000)+2000; 
				int trainTypeRandom = random.nextInt(1);
				
				Thread.sleep(trainIntervalTime);
				if (trainTypeRandom == 0){
					//DIFFERENCE TRAIN AND FASTTRAIN DECLARATION
					//IF I USE THE SAME NAME ARE THEY DIFFERENT OBJECTS OR THE SAME OBJECT
					Train newFastTrain = new FastTrain();
					new Thread(newFastTrain).start();
					trainList.add(newFastTrain);

					
				}
				else {
					Train newSlowTrain = new SlowTrain();
					new Thread(newSlowTrain).start();
					trainList.add(newSlowTrain);
				}
				
//				for(int i=0;i<trainList.size();i++) {
//				System.out.println(trainList.get(i).getId());
//			}
				
				for(int i=0;i<trainList.size();i++) {
					if(trainList.get(i).getPosition() == RunMe.getRailwayList().size()) {
						trainList.remove(i);
					}
				
			}
					
			}
		}catch(InterruptedException e) {
			
		}
		
	}

	public ArrayList<Train> getTrainList() {
		return trainList;
	}

}
