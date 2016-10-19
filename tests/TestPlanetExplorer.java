import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	PlanetExplorer explorer = new PlanetExplorer(3, 3, "(0,1)");
	String returnValue;
	
	@Test
	public void test_executeCommand_forwardOnce() {
		returnValue = explorer.executeCommand("f");
		assertEquals("(0,1,N)", returnValue);
	}
	
	@Test
	public void test_executeCommand_turnRight() {
		returnValue = explorer.executeCommand("r");
		assertEquals("(0,0,E)", returnValue);
	}
	
	@Test
	public void test_executeCommand_turnLeft() {
		returnValue = explorer.executeCommand("l");
		assertEquals("(0,0,W)", returnValue);
	}
	
	@Test
	public void test_executeCommand_backwardsWrap() {
		returnValue = explorer.executeCommand("b");
		assertEquals("(0,2,N)", returnValue);
	}
	
	@Test
	public void test_executeCommand_forwardToObstacle() {
		returnValue = explorer.executeCommand("f");
		assertEquals("(0,0,N)(0,1)", returnValue);
	}
}
