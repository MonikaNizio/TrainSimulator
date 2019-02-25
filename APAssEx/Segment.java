//abstract class
public abstract class Segment {
	String name;
	int length;
	int capacity;
	
	Segment(String name, int length, int capacity){
		this.name = name;
		this.length = length;
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
