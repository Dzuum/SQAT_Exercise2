import java.util.ArrayList;
import java.util.List;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 112
// Finish time:

public class PlanetExplorer {
	int gridWidth;
	int gridHeight;

	ExplorerVector2D position;
	ExplorerVector2D direction;
	
	List<String> gridObstacles = new ArrayList<String>();
	
	public PlanetExplorer(int x, int y, String obstacles) {
		/*	x and y represent the size of the grid.
		 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
		 *  
			Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
			PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
			 
		 */
		
		gridWidth = x;
		gridHeight = y;

		position = new ExplorerVector2D(0, 0);
		direction = new ExplorerVector2D(0, 1);
		
		String[] splitObstacles = obstacles.split("\\),\\(|\\)|\\(");
		for (String obstacle : splitObstacles) {
			gridObstacles.add("(" + obstacle + ")");
		}
	}
	
	public String executeCommand(String command) {
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		ExplorerVector2D nextPosition;
		List<ExplorerVector2D> foundObstacles = new ArrayList<ExplorerVector2D>();
		
		for (int i = 0; i < command.length(); i++) {
			char cmd = command.charAt(i);
			
			if (cmd == 'f') {
				nextPosition = new ExplorerVector2D(position);
				nextPosition.add(direction);
				nextPosition.wrapPositive(gridWidth - 1, gridHeight - 1);
				
				if (!gridObstacles.contains("(" + nextPosition.getValuesString() + ")"))
					position = new ExplorerVector2D(nextPosition);
				else
					foundObstacles.add(nextPosition);
			} else if (cmd == 'b') {
				nextPosition = new ExplorerVector2D(position);
				nextPosition.negate(direction);
				nextPosition.wrapPositive(gridWidth - 1, gridHeight - 1);
				
				if (!gridObstacles.contains("(" + nextPosition.getValuesString() + ")"))
					position = new ExplorerVector2D(nextPosition);
				else
					foundObstacles.add(nextPosition);
			} else if (cmd == 'l') {
				direction.rotateLeft();
			} else if (cmd == 'r') {
				direction.rotateRight();
			}
		}
		
		for (int i = 0; i < foundObstacles.size(); i++) {
			for (int j = i + 1; j < foundObstacles.size(); j++) {
				if (foundObstacles.get(i).equals(foundObstacles.get(j)) {
					foundObstacles.remove(j);
					j--;
				}
			}
		}
		
		String value = getPositionFormatted();
		for (ExplorerVector2D obstacle : foundObstacles)
			value += "(" + obstacle.getValuesString() + ")";
		
		return value;
	}
	
	private String getPositionFormatted() {
		return "(" + position.getValuesString() + "," + direction.getFacingString() + ")";
	}
}
