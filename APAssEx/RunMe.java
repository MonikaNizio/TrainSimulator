import java.util.ArrayList;

public class RunMe {

	private static ArrayList<Segment> railwayList = new ArrayList<Segment>();

	public static void main(String[] args) {

		ArrayList<Station> stationList = new ArrayList<Station>();

		TrafficGenerator trafficGenerator = new TrafficGenerator();
		PrintRailway printRailway = new PrintRailway(trafficGenerator);
		new Thread(printRailway).start();

		// create stations
		Station Glasgow = new Station("Glasgow", 3);
		Station Stirling = new Station("Stirling", 2);
		Station Perth = new Station("Perth", 2);
		Station Inverness = new Station("Inverness", 3);

		stationList.add(Glasgow);
		stationList.add(Stirling);
		stationList.add(Perth);
		stationList.add(Inverness);

		Railway railway = new Railway(stationList);

		railwayList = railway.createRailway(stationList);

	}

	public static ArrayList<Segment> getRailwayList() {
		return railwayList;
	}

}
