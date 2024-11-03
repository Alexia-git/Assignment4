import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagmentCompnatTestStudent {
	Property sampleProperty;
	ManagementCompany mangementCo ;
	
	@BeforeEach
	void setUp() throws Exception {
		mangementCo= new ManagementCompany("Amanda", "1234567",4);

	}

	@AfterEach
	void tearDown() throws Exception {
		mangementCo= null;

	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Starbucks", "Elta", 321, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),1,1);	
	}
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Starbucks", "Elta", 3450, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),1,1);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}
	@Test
	public void testToString() {
		sampleProperty = new Property ("Starbucks", "Elta", 3450.0, "BillyBob Wilson",2,5,2,2);
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	
		String expectedString = "List of the Properties for Amanda, TaxID: 1234567\n"
				+ "______________________________________________________\n"
				+ "Starbucks,Elta,BillyBob Wilson,3450.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 138.0";
		System.out.println(expectedString);
		System.out.println(mangementCo.toString());
		assertEquals(expectedString, mangementCo.toString());
				
	}


}
