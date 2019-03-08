
public abstract class Segment {
	protected final String name;
	protected final int length;
	protected final int maxCapacity;
	protected int currentCapacity = 0;

	Segment(String name, int length, int maxCapacity, int currentCapacity) {
		this.name = name;
		this.length = length;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = currentCapacity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}

	public boolean checkSegmentFull() {
		if (this.currentCapacity >= this.maxCapacity) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}

	public void addCurrentCapacity() {
		this.currentCapacity = this.currentCapacity + 1;
	}

	public void deductCurrentCapacity() {
		this.currentCapacity = this.currentCapacity - 1;
	}

}
