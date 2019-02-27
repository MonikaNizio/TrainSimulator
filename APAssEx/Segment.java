import java.util.ArrayList;

//abstract class
public abstract class Segment {
	//FINAL ATTRIBUTES?
	private String name;
	private int length;
	private int capacity;
	//protected ArrayList<Train> trainsInSegment = new ArrayList<Train>(capacity);
	
	Segment(String name, int length, int capacity){
		this.name = name;
		this.length = length;
		this.capacity = capacity;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

//	public ArrayList<Train> getTrainsInSegment() {
//		return trainsInSegment;
//	}
//
//	public void setTrainsInSegment(ArrayList<Train> trainsInSegment) {
//		this.trainsInSegment = trainsInSegment;
//	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
