package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mainCode.Animal;
import mainCode.BIOME;
import mainCode.Enclosure;
import mainCode.Lion;

public class TestEnclosure {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testAddAnimalTrue() {
		Animal leo = new Lion("Leo", "male", true);
		Enclosure enclosure = new Enclosure(100, BIOME.SAVANAH);
		boolean result = enclosure.addAnimal(leo);
		assertEquals(true, result);
		assertEquals(50, enclosure.getPlotSize());
		assertEquals(1, enclosure.getAnimals().size());
	}
	
	@Test
	public void testAddAnimalFalse() {
		Animal leo = new Lion("Leo", "male", true);
		Enclosure enclosure = new Enclosure(40, BIOME.SAVANAH);
		boolean result = enclosure.addAnimal(leo);
		assertEquals(false, result);
		assertEquals(40, enclosure.getPlotSize());
		assertEquals(0, enclosure.getAnimals().size());
	}
	
	@Test 
	public void TestRemoveAnimal(){
		Animal leo = new Lion("Leo", "male", true);
		Enclosure enclosure = new Enclosure(100, BIOME.SAVANAH);
		enclosure.addAnimal(leo);
		enclosure.removeAnimal();
}
}
