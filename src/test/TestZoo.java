package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import mainCode.*;

public class TestZoo {
	
	private Zoo testZoo;
	private Animal testAnimal;
	private Visitor testVisitor;
	private Zoo testZoo2;
	
	@Before
	public void before(){
		testAnimal = new FireDragon("Robo", "male", true);
		testZoo = new Zoo();
		testVisitor = new Visitor("Larry", "male", true, 50);
		testZoo2 = new Zoo();
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
	
//	@Test
	//this was used for testing when baby animal was sold(removed) but not added to another zoo.
//	
//	public void zooCanSellBabyLion(){
//		Animal babyLion = new FireDragon("Fifa", "female", false);
//		testZoo.createSuitableEnclosure(babyLion);
//		Enclosure enclosure = testZoo.getEnclosures().get(0);
//		boolean result = enclosure.addAnimal(babyLion);
//		assertEquals(true, result);
//		assertEquals(1, enclosure.getAnimals().size());
//		boolean result2 = testZoo.sellBabyAnimal(babyLion);
//		assertEquals(true, result2);
//		assertEquals(0, enclosure.getAnimals().size());
//		assertEquals(300, testZoo.getBudget());
//	}
	
//	@Test
//	
//	public void zooCanSellBabyLionToAnotherZoo(){
//		Animal babyDragon = new FireDragon("Fifa", "female", false);
//		testZoo.addAnimalToZoo(babyDragon);
//		assertEquals(1, testZoo.getUnplacedAnimals().size());
//		Zoo testZoo2 = new Zoo();
//		testZoo2.setBudget(1000);
//		boolean result2 = testZoo.sellBabyAnimal(babyDragon.getName(), testZoo2);
//		assertEquals(true, result2);
//		assertEquals(800, testZoo2.getBudget());
//		assertEquals(300, testZoo.getBudget());	
//		assertEquals(0, testZoo.getUnplacedAnimals().size());
//		assertEquals(1, testZoo2.getUnplacedAnimals().size());
//	}
	
	@Test 
	public void testChekingIfZooCanBuyAnimalTrue(){
		testZoo2.setBudget(1000);
		Animal babyDragon = new FireDragon("Fifa", "female", false);
		boolean result = testZoo2.checkCanAffordAnimal(babyDragon);
		assertEquals(true, result);
	}
	
	@Test 
	public void testChekingIfZooCanBuyAnimalFalse(){
		Animal babyDragon = new FireDragon("Fifa", "female", false);
		boolean result = testZoo2.checkCanAffordAnimal(babyDragon);
		assertEquals(false, result);
	}
	
	@Test 
	public void testFindAnimalInTheZooTrue(){
		testZoo.addAnimalToZoo(testAnimal);
		Animal foundAnimal = testZoo.findUnplacedAnimal(testAnimal.getName());
		assertEquals(testAnimal, foundAnimal);
	}
	
	@Test 
	public void testFindAnimalInTheZooFalse(){
		Animal foundAnimal = testZoo.findUnplacedAnimal(testAnimal.getName());
		assertEquals(null, foundAnimal);
	}

}
