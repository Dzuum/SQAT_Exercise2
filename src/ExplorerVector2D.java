
public class ExplorerVector2D {
	int x;
	int y;
	
	public ExplorerVector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public ExplorerVector2D(ExplorerVector2D other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	public void add(ExplorerVector2D other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public void negate(ExplorerVector2D other) {
		this.x -= other.x;
		this.y -= other.y;
	}
	
	public void wrapPositive(int xMax, int yMax) {
		if (x < 0)
			x = xMax;
		else if (x > xMax)
			x = 0;
		
		if (y < 0)
			y = yMax;
		else if (y > yMax)
			y = 0;
	}
	
	public void rotateLeft() {
		if (x == 1 && y == 0) {
			x = 0;
			y = 1;
		} else if (x == -1 && y == 0) {
			x = 0;
			y = -1;
		} else if (y == 1 && x == 0) {
			x = -1;
			y = 0;
		} else if (y == -1 && x == 0) {
			x = 1;
			y = 0;
		}
	}
	
	public void rotateRight() {
		if (x == 1 && y == 0) {
			x = 0;
			y = -1;
		} else if (x == -1 && y == 0) {
			x = 0;
			y = 1;
		} else if (y == 1 && x == 0) {
			x = 1;
			y = 0;
		} else if (y == -1 && x == 0) {
			x = -1;
			y = 0;
		}
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
	
	public String getValuesString() {
		return x + "," + y;
	}
	
	public boolean equals(ExplorerVector2D other) {
		return ((x == other.x) && (y == other.y));
	}
}
