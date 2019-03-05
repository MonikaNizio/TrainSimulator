
public abstract class Train implements Runnable {
	protected int id;
	static int counter = 1;
	protected int speed;
	protected int position = 0;
	//protected Track currentTrack;
	
	Train(int id, int speed, int position){
		this.id = counter++;
		this.speed = speed;
		this.position = position;
	}
	
	public void run() {
		try {

			while(position <= RunMe.getRailwayList().size()) {
				try {
				if (RunMe.getRailwayList().get(position) instanceof Track) {
					Thread.sleep(timeOnTrack(RunMe.getRailwayList().get(position).getLength()));
				}
				else {
					Thread.sleep(timeInStation(RunMe.getRailwayList().get(position).getLength()));
				}
//				Thread.sleep(1000 * RunMe.getRailwayList().get(position).getLength() /this.speed);
//				//System.out.println(RunMe.getRailwayList().get(position).getLength());
//				//System.out.println(this.speed + " " + position);
				position++;
				//Track next = currentTrack.getNext();
				}
				catch(IndexOutOfBoundsException e) {
					//FIX THIS
				}
			}

			}
		 catch (InterruptedException e) {

		}
	}
	
	public int timeOnTrack(int length) {
		
		//DOES this. TAKE SPEED FROM THE SUPERCLASS OR NOT?
		//multiply by 1000 to get seconds rather than ms to be used in thread
		int time = 1000 * length/this.speed;
		return time;
	}
	
	public int timeInStation(int length) {
		int time = 1000 * length/this.speed + 5000;
		return time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	

//	public void setNext(Track next) {
//		this.next = next;
//	}
//
//	public Track getNext() {
//		return next;
//	}

	
	
}
