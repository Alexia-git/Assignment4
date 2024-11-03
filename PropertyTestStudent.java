import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	Property property1 , property2;

	@BeforeEach
	void setUp() throws Exception {
		property1 = new Property("Property Alex", "Hyattsville", 1560.00, "School");
		property2 = new Property("Property Elta", "College park", 2305.00, "Pool");
	}

	@AfterEach
	void tearDown() throws Exception {
		property1 = null;
		property2 = null;

	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property Alex", property1.getPropertyName());
		assertEquals("Property Elta", property2.getPropertyName());


	}
	@Test
	void testGetRentAmount() {
		assertEquals(1560.00, property1.getRentAmount());
		assertEquals(2305.00, property2.getRentAmount());
	}
	@Test
	void testGetPlot() {
		assertEquals(0, property1.getPlot().getX());
		assertEquals(0, property1.getPlot().getY());
		assertEquals(1, property1.getPlot().getWidth());
		assertEquals(1, property1.getPlot().getDepth());
	
		
	}
	@Test
	void testToString() {
		assertEquals("Property Alex,Hyattsville,School,1560.0",property1.toString());	
		assertEquals("Property Elta,College park,Pool,2305.0",property2.toString());	
	}

	
	


}
