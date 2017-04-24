package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mainCode.Animal;
import mainCode.Lion;
import mainCode.Plant;
import mainCode.Rabbit;

public class TestAnimals {

	private Plant carrot;
	private Lion leo;
	private Rabbit rabbit;
	
	
	@Before
	public void before(){
		carrot = new Plant("carrot", 5);
		leo = new Lion("Leo", "male", true);
		rabbit = new Rabbit("Zizi", "female", true);
	}

	@Test
	public void testLionCannotEatCarrot() {
		
		boolean result = leo.eat(carrot);
		assertEquals(false, result);
		assertEquals(50, leo.checkHunger());
	}
	
	@Test 
	public void testLionCanEatRabbit(){
		boolean result = leo.eat(rabbit);
		assertEquals(true, result);
		assertEquals(120, leo.checkHunger());
	}
	
	@Test
	public void testRabbitCanEatCarrot() {
		boolean result = rabbit.eat(carrot);
		assertEquals(true, result);
		assertEquals(55, rabbit.checkHunger());
	}
}
