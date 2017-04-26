package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mainCode.*;

public class TestAnimals {

	private Plant carrot;
	private FireDragon leo;
	private Unicorn unicorn;
	
	
	@Before
	public void before(){
		carrot = new Plant("carrot", 5);
		leo = new FireDragon("Leo", "male", true);
		unicorn = new Unicorn("Zizi", "female", true);
	}

	@Test
	public void testDragonCannotEatCarrot() {
		boolean result = leo.eat(carrot);
		assertEquals(false, result);
		assertEquals(50, leo.checkHunger());
	}
	
	@Test 
	public void testDragonCanEatUnicorn(){
		boolean result = leo.eat(unicorn);
		assertEquals(true, result);
		assertEquals(120, leo.checkHunger());
	}
	
	@Test
	public void testUnicornCanEatCarrot() {
		boolean result = unicorn.eat(carrot);
		assertEquals(true, result);
		assertEquals(55, unicorn.checkHunger());
	}
	
	@Test 
	
	public void testUnicornCanDie() {
		boolean result = leo.eat(unicorn);
		assertEquals(true, result);
		assertEquals(true, unicorn.getIsDead());
	}
	
	@Test 
	public void testAnimalHasAZoo(){
		Zoo testZoo = new Zoo();
		testZoo.placeAnimalInEnclosure(unicorn);
		assertEquals(testZoo, unicorn.getZoo());
	}
	
	@Test 
	
	public void testAnimalRampage(){
		Visitor visitor = new Visitor("Tony", "male", true, 300);
		Zoo testZoo = new Zoo();
		testZoo.placeAnimalInEnclosure(unicorn);
		testZoo.placeAnimalInEnclosure(leo);
		testZoo.sellTicket(visitor);
		leo.rampage();
		assertEquals(true, visitor.getIsDead());
		assertEquals(leo, testZoo.findUnplacedAnimal("Leo"));
		assertEquals(null, testZoo.findAnimalInEnclosures("Leo"));
		testZoo.returnAnimalToCageFromUnplacedAnimals();
		assertEquals(null, testZoo.findUnplacedAnimal("Leo"));
		assertEquals(leo, testZoo.findAnimalInEnclosures("Leo"));
	}
 }
