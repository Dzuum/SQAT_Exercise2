import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand_forwardOnce() {
		fail("Not yet implemented");
		
		PlanetExplorer explorer = new PlanetExplorer(3, 3, "");
		String ret = explorer.executeCommand("f");
		
		assertEquals("(0,1,N)", ret);
	}
}
