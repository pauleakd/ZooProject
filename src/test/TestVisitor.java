package test;

import mainCode.Visitor;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestVisitor {
	
	private Visitor visitor;
	
	@Before
	public void before(){
	visitor = new Visitor("Paule", "female", true, 100 );}
	
	@Test
	public void testSetup(){
		String name = visitor.getName();
		assertEquals("Paule", name);
	}
	
	@Test 
	public void testBuyTicketTrue(){
		boolean result = visitor.buyTicket(20);
		assertEquals(true, result);
		assertEquals(80, visitor.getMoney());
	}
	
	@Test 
	public void testBuyTicketFalse(){
		boolean result = visitor.buyTicket(120);
		assertEquals(false, result);
		assertEquals(100, visitor.getMoney());
	}
}
