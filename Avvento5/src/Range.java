
public class Range {
	public long start;
	public long end;
	public long length;
	
	public Range(long start, long length) {
		this.start=start;
		this.end=start+length-1;
		this.length=length;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
		this.length=end-this.start;
	}
	
	
}
