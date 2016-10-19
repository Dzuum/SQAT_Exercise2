import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	
	@Test
	public void test_executeCommand_forwardOnce() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String returnValue = explorer.executeCommand("f");
		assertEquals("(0,1,N)", returnValue);
	}
	
	@Test
	public void test_executeCommand_turnRight() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String returnValue = explorer.executeCommand("r");
		assertEquals("(0,0,E)", returnValue);
	}
	
	@Test
	public void test_executeCommand_turnLeft() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String returnValue = explorer.executeCommand("l");
		assertEquals("(0,0,W)", returnValue);
	}
	
	@Test
	public void test_executeCommand_backwardsWrap() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String returnValue = explorer.executeCommand("b");
		assertEquals("(0,2,N)", returnValue);
	}
	
	@Test
	public void test_executeCommand_forwardToObstacle() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "(0,1)");
		String returnValue = explorer.executeCommand("f");
		assertEquals("(0,0,N)(0,1)", returnValue);
	}
	
	@Test
	public void test_executeCommand_twiceForwardToObstacle() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "(0,1)");
		String returnValue = explorer.executeCommand("ff");
		assertEquals("(0,0,N)(0,1)", returnValue);
	}
	
	@Test
	public void test_executeCommand_wrapBackwardsToObstacle() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "(0,2)");
		String returnValue = explorer.executeCommand("b");
		assertEquals("(0,0,N)(0,2)", returnValue);
	}
	
	@Test
	public void test_givenExample1() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String returnValue = explorer.executeCommand("ffrf");
		assertEquals("(1,2,E)", returnValue);
	}
	
	@Test
	public void test_givenExample2() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "(0,2)");
		String returnValue = explorer.executeCommand("ffrf");
		assertEquals("(1,1,E)(0,2)", returnValue);
	}
	
	@Test
	public void test_createExplorer_invalidSize() {
		PlanetExplorer explorer = new PlanetExplorer(-1, 3, "");
	}
}
