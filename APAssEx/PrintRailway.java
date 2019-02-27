
public class PrintRailway implements Runnable {

	public PrintRailway() {

	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				//CREATE RunMe OBJECT FIRST?
				for(int i=0; i<RunMe.getRailwayList().size(); i++) {
					System.out.print("|----" + RunMe.getRailwayList().get(i).toString() + "--");
//					for(int j=0; j<RunMe.getRailwayList().get(i).getTrainsInSegment().size(); j++) {
//						RunMe.getRailwayList().get(i).getTrainsInSegment().get(i);
//						System.out.print(Train.getId() + ",");
//					}
					System.out.print("----|");

				}
				System.out.println();

			}
		} catch (InterruptedException e) {

		}
	}
}
