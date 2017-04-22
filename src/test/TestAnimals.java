package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mainCode.Animal;
import mainCode.Lion;
import mainCode.Plant;

public class TestAnimals {


	@Test
	public void test() {
		Plant carrot = new Plant("carrot", 5);
		Lion leo = new Lion("Leo", "male", true);
		String result = leo.eat(carrot);
		assertEquals("Lion Leo ate carrot", result);
		assertEquals(55, leo.checkHunger());
	}

}
