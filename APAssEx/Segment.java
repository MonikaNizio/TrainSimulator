//import java.util.ArrayList;

//abstract class
public abstract class Segment {
	String name;
	int length;
	int capacity;
	
	Segment(String name, int length, int capacity){
		this.name = name;
		this.length = length;
		this.capacity = capacity;
		//ArrayList<Train> trainsInSegment = new ArrayList<Train>(capacity);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}

	public String getName() {
		return name;
	}
	
	
}
