import java.util.ArrayList;

//abstract class
public abstract class Segment {
	//FINAL ATTRIBUTES?
	protected String name;
	protected int length;
	protected int maxCapacity;
	//protected int currentCapacity = 0;
	//protected ArrayList<Train> trainsInSegment = new ArrayList<Train>(capacity);
	
	Segment(String name, int length, int maxCapacity){
		this.name = name;
		this.length = length;
		this.maxCapacity = maxCapacity;
		//this.currentCapacity = currentCapacity;
		//this.trainsInSegment = trainsInSegment;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
	
//	public void addTrainToArrayList(Train train) {
//		this.trainsInSegment.add(train);
//	}
//	
//	public void removeTrainFromArrayList(Train train) {
//		this.trainsInSegment.remove(train);
//	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	

//	public ArrayList<Train> getTrainsInSegment() {
//		return trainsInSegment;
//	}
//
//	public void setTrainsInSegment(ArrayList<Train> trainsInSegment) {
//		this.trainsInSegment = trainsInSegment;
//	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

//	public int getCurrentCapacity() {
//		return currentCapacity;
//	}
//
//	public void setCurrentCapacity(int currentCapacity) {
//		this.currentCapacity = currentCapacity;
//	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
