import java.util.ArrayList;

public class Railway {
	public Railway() {

	}

	public ArrayList<Segment> createRailway(ArrayList<Station> stationList){
		ArrayList<Segment> railwayList = new ArrayList<Segment>();
		//int stationListSize = stationList.size();
		while(true) {
			railwayList.add(stationList.remove(0));
			if (stationList.isEmpty()) {
				break;
			}
			railwayList.add(new Track());
		}
		
		return railwayList;
	}

//	@Override
//	public String toString() {
//		return "Railway [toString()=" + super.toString(railwayList) + "]";
//	}

	
	
}
