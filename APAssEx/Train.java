
public abstract class Train implements Runnable {
	static int id = 0;
	int speed;
	private Track currentTrack;
	
	Train(int id, int speed){
		Train.id = id + 1;
		this.speed = speed;
	}
	
	public void run() {
		try {

			while(true) {
				Thread.sleep(1000/500);
				Track next = currentTrack.getNext();
			}

			}
		 catch (InterruptedException e) {

		}
	}
	
	public int timeOnTrack(int length) {
		
		//DOES this. TAKE SPEED FROM THE SUPERCLASS OR NOT?
		int time = length/this.speed;
		return time;
	}
	
	public int timeInStation(int length) {
		int time = length/this.speed + 5;
		return time;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Train.id = id;
	}
	
	

//	public void setNext(Track next) {
//		this.next = next;
//	}
//
//	public Track getNext() {
//		return next;
//	}

	
	
}
