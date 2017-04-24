package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import mainCode.*;

public class TestZoo {
	
	private Zoo testZoo;
	private Animal testAnimal;
	private Visitor testVisitor;
	
	@Before
	public void before(){
		testAnimal = new Lion("Robo", "male", true);
		testZoo = new Zoo();
		testVisitor = new Visitor("Larry", 50);
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
	
	@Test 
	public void testSellTicketTrue(){
		boolean result = testZoo.sellTicket(testVisitor);
		assertEquals(true, result);
		assertEquals(1, testZoo.getVisitors().size());
		assertEquals(120, testZoo.getBudget());
	}
	
	@Test 
	public void testSellTicketFalse(){
		testZoo.setTicketPrice(60);
		boolean result = testZoo.sellTicket(testVisitor);
		assertEquals(false, result);
		assertEquals(0, testZoo.getVisitors().size());
		assertEquals(100, testZoo.getBudget());
	}

}
