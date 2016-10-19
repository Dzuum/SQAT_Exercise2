
public class ExplorerVector2D {
	int x;
	int y;
	
	public int X() { return x; }
	public int Y() { return y; }
	
	public ExplorerVector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(ExplorerVector2D other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public String getFacingString() {
		String ret = "Not an identity vector";
		
		
		
		return ret;
	}
}
