
public class ExplorerVector2D {
	int x;
	int y;
	
	public ExplorerVector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(ExplorerVector2D other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public String getFacingString() {
		
	}
}