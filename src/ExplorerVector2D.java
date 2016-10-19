
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
		
		if (x == 1 && y == 0) {
			ret = "E";
		} else if (x == -1 && y == 0) {
			ret = "W";
		} else if (y == 1 && x == 0) {
			ret = "N";
		} else if (y == -1 && x == 0) {
			ret = "S";
		}
		
		return ret;
	}
}
