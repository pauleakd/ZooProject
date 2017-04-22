package test;

import static org.junit.Assert.*;
import mainCode.*;

import org.junit.Test;


public class PlantTest {

	@Test
	public void testPlant() {
		Plant myPlant = new Plant("carrot", 5);
		assertEquals(myPlant.getNutritionalValue(), 5);
	}

}
