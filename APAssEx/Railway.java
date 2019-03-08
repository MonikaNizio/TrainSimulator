import java.util.ArrayList;

public class Railway {

	private ArrayList<Segment> railwayList = new ArrayList<Segment>();
	private ArrayList<Station> stationList = new ArrayList<Station>();

	public Railway(ArrayList<Station> stationList) {
		this.stationList = stationList;
	}

	public ArrayList<Segment> createRailway(ArrayList<Station> stationList) {

		// add tracks between the stations
		while (true) {
			railwayList.add(stationList.remove(0));
			if (stationList.isEmpty()) {
				break;
			}
			railwayList.add(new Track());
		}

		return railwayList;
	}

	public ArrayList<Segment> getRailwayList() {
		return railwayList;
	}

}
