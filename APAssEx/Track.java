
public class Track extends Segment{

	private Track next;
	
	public Track() {

		super("track", 1000, 1);
		// TODO Auto-generated constructor stub
	}

	public void setNext(Track next) {
		this.next = next;
	}

	public Track getNext() {
		return next;
	}

}
