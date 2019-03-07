
public class PrintRailway implements Runnable {

	private TrafficGenerator trafficGenerator;

	public PrintRailway(TrafficGenerator trafficGenerator) {
		this.trafficGenerator = new TrafficGenerator();
	}

	public void run() {
		try {
			new Thread(trafficGenerator).start();
			while (true) {
				Thread.sleep(1000);
				
				//CREATE RunMe OBJECT FIRST?
				for(int i=0; i<RunMe.getRailwayList().size(); i++) {
					System.out.print("|----" + RunMe.getRailwayList().get(i).toString() + "--");
					//HOW TO ACCESS TRAFFIC GENERATOR? NEEDS AN OBJECT?
					//print trains
					for(int j=0;j<trafficGenerator.getTrainList().size();j++) {
						if (trafficGenerator.getTrainList().get(j).getPosition() == i) {
							System.out.print(trafficGenerator.getTrainList().get(j).getId() + ",");
						}
					}
					
					System.out.print("----|");

				}
				System.out.println();
								
			}
		} catch (InterruptedException e) {

		}
	}
}
