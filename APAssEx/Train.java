
public abstract class Train {
	int ID;
	int speed;
	
	Train(int ID, int speed){
		this.ID = ID;
		this.speed = speed;
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

}
