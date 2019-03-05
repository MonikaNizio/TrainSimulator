import java.util.ArrayList;

public class RunMe {
	
	static private ArrayList<Segment> railwayList = new ArrayList<Segment>();
	//public static Train newTrain = new SlowTrain();

	public static void main(String[] args) {
		//Train newTrain = new FastTrain();
		TrafficGenerator trafficGenerator = new TrafficGenerator();
//		new Thread(trafficGenerator).start();
		PrintRailway printRailway = new PrintRailway(trafficGenerator);
		//Thread printThread = new Thread(printRailway);
		 new Thread(printRailway).start();
		//Thread printThread = new Thread(new PrintRailway(trafficGenerator));
		
		//Thread trainThread = new Thread(newTrain);
		//printThread.start();
		
		//trainThread.start();
		ArrayList<Station> stationList = new ArrayList<Station>();

		//MAKE THIS ADAPTABLE TO DIFFERENT NUMBER OF STATIONS
		
		//create stations
			Station Glasgow = new Station("Glasgow", 3);
			Station Stirling = new Station("Stirling", 2);
			Station Perth = new Station("Perth", 2);
			Station Inverness = new Station("Inverness", 3);

			stationList.add(Glasgow);
			stationList.add(Stirling);
			stationList.add(Perth);
			stationList.add(Inverness);
			
			Railway railway = new Railway();

			railwayList = railway.createRailway(stationList);
			
			//System.out.println(railwayList.toString());
			
//			Train train = new FastTrain();
//			Train trainslow = new SlowTrain();
//			Train trainslow2 = new SlowTrain();
//			
//			System.out.println(train.getId() + " " + trainslow.getId() + " " + trainslow2.getId());
	}

	public static ArrayList<Segment> getRailwayList() {
		return railwayList;
	}

	
	
//    @Override
//    public String toString() {
//        return railwayList.toString();
//     }
	
	
}
