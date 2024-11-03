import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1, plot2;

	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(1,1,6,6); 
		plot2 = new Plot(1,1,3,2);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1=null;
	}

	@Test
	public void testOverlaps1() {
		assertTrue(plot1.overlaps(plot2)); 
		
	}
	@Test
	public void testEncompasses1() {
		assertTrue(plot1.encompasses(plot2));
		assertFalse(plot2.encompasses(plot1));
		
		
	}
}
