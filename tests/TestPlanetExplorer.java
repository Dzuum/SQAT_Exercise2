import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand_forwardOnce() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String ret = explorer.executeCommand("f");
		
		assertEquals("(0,1,N)", ret);
	}
	
	@Test
	public void test_executeCommand_turnRight() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String ret = explorer.executeCommand("r");
		
		assertEquals("(0,0,E)", ret);
	}
	
	@Test
	public void test_executeCommand_turnLeft() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String ret = explorer.executeCommand("l");
		
		assertEquals("(0,0,W)", ret);
	}
	
	@Test
	public void test_executeCommand_backwardsWrap() {
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String ret = explorer.executeCommand("b");
		
		assertEquals("(0,1,N)", ret);
	}
}
