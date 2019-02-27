import java.util.ArrayList;

public class RunMe {
	
	static private ArrayList<Segment> railwayList = new ArrayList<Segment>();

	public static void main(String[] args) {
		Thread printThread = new Thread(new PrintRailway());
		Thread trainThread = new Thread(new FastTrain(1, 500));
		printThread.start();
		trainThread.start();
		ArrayList<Station> stationList = new ArrayList<Station>();

		//MAKE THIS ADAPTABLE TO DIFFERENT NUMBER OF STATIONS
		
		//create stations
			Station Glasgow = new Station("Glasgow", 3);
			Station Stirling = new Station("Stirling", 2);
			Station Perth = new Station("Perth", 1);
			Station Inverness = new Station("Inverness", 1);

			stationList.add(Glasgow);
			stationList.add(Stirling);
			stationList.add(Perth);
			stationList.add(Inverness);
			
			Railway railway = new Railway();

			railwayList = railway.createRailway(stationList);
			
			//System.out.println(railwayList.toString());
	}

	public static ArrayList<Segment> getRailwayList() {
		return railwayList;
	}

	
	
//    @Override
//    public String toString() {
//        return railwayList.toString();
//     }
	
	
}
