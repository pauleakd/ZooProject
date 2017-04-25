package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mainCode.*;
import mainCode.FireDragon;
import mainCode.Plant;
import mainCode.Unicorn;

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
}
