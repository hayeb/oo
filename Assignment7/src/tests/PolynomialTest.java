package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import polynomials.Polynomial;

/**
 * A test class for the Polynomial class. Tests the toString, plus, minus, times and apply methods.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class PolynomialTest {

	@Test
	public void testToString() {
		Polynomial p1 = new Polynomial( "3.0 1 2 3" );
        Polynomial p2 = new Polynomial( "4 0 -5 3" );
        Polynomial p3 = new Polynomial( "-4 0 5 3" );
        assertEquals("2.000000x^3 + 3.000000x", p1.toString());
        assertEquals("-5.000000x^3 + 4.000000", p2.toString());    
        assertEquals("5.000000x^3 -4.000000", p3.toString()); 
	}

	@Test
	public void testPlus() {
		Polynomial p1 = new Polynomial( "3.0 1 2 3" );
        Polynomial p2 = new Polynomial( "4 0 -5 3" );
        p1.plus(p2);
        assertEquals("p1 plus p2 1:", "-3.000000x^3 + 3.000000x + 4.000000", p1.toString());
        
        p1 = new Polynomial("1.0 6 2 3 2 4");
        p2 = new Polynomial("1 0 1 2 1 4");
        p1.plus(p2);
        assertEquals("p1 plus p2 2:", "1.000000x^6 + 3.000000x^4 + 2.000000x^3 + 1.000000x^2 + 1.000000", p1.toString());
        

        p1 = new Polynomial("5 2");
		p2 = new Polynomial("-5 2");
		p1.plus(p2);
		assertEquals("p1 plus p2 (add to 0)", "", p1.toString());
	}

	@Test
	public void testMinus() {
//		Polynomial p1 = new Polynomial("5 2");
//		Polynomial p2 = new Polynomial("1 2 -5 4 1 1 -3 0");
//		p1.minus(p2);
//		assertEquals("negative p2", "5.000000x^4 -1.000000x^2 -1.000000x + 3.000000", p2.toString());
		Polynomial p1 = new Polynomial("5 2");
		Polynomial p2 = new Polynomial("5 2");
		p1.minus(p2);
		assertEquals("p1 minus p2", "", p1.toString());
	}

	@Test
	public void testTimes() {
		Polynomial p1 = new Polynomial("1 2");
		p1.times(p1);
		assertEquals("Times p1*p1", "1.000000x^4", p1.toString());
		p1 = new Polynomial("1 2");
		Polynomial p2 = new Polynomial("2 4");
		p2.times(p1);
		assertEquals("Times p1*p2", "2.000000x^6", p2.toString());
		p1 = new Polynomial("1 2 1 3 1 4");
		p2 = new Polynomial("1 2 1 3 1 4");
		p1.times(p2);
		assertEquals("Times p1*p1", "1.000000x^8 + 2.000000x^7 + 3.000000x^6 + 2.000000x^5 + 1.000000x^4", p1.toString());
		
	}
	
	@Test
	public void testApply() {
		Polynomial p1 = new Polynomial("1 2");
		assertEquals("P1 with input 1", 1, p1.apply(1));
		assertEquals("P1 with input 2", 4, p1.apply(2));
		
		Polynomial p2 = new Polynomial("1 8 2 7 3 6 2 5 1 4");
		assertEquals("P2 with input 2", 784, p2.apply(2));
		assertEquals("P2 with input 1", 9, p2.apply(1));
		assertEquals("P2 with input 0", 0, p2.apply(0));
	}

}
