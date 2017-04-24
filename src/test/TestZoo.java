package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import mainCode.*;

public class TestZoo {
	
	private Zoo testZoo;
	private Animal testAnimal;
	
	@Before
	public void before(){
		testAnimal = new Lion("Robo", "male", true);
		testZoo = new Zoo();
	}
	
	@Test 
	public void testSetUp(){
		assertEquals(0, testZoo.getEnclosures().size());
		assertEquals(20, testZoo.getTicketPrice());
		testZoo.setTicketPrice(30);
		assertEquals(30, testZoo.getTicketPrice());
	}
	
	@Test
	public void testEnclosureCreation(){
		testZoo.createSuitableEnclosure(testAnimal);
		Enclosure enclosure = testZoo.getEnclosures().get(0);
		assertEquals(50, enclosure.getPlotSize());
		assertEquals(BIOME.SAVANAH, enclosure.getBiome());
	}

}
