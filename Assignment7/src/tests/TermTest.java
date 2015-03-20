package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import polynomials.Term;

/**
 * For testing the terms class.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class TermTest {

	/**
	 * tests the plus function in the Terms class.
	 */
	@Test
	public void testPlus() {
		Term t1 = new Term(2.0, 3);
		Term t2 = new Term(-2.0, 3);
		t1.plus(t2);
		assertEquals(0, t1.getCoef(), 0.00005);
		t1 = new Term(0.0, 3);
		t2 = new Term(0.0, 3);
		t1.plus(t1);
		assertEquals(0, t1.getCoef(), 0.00005);
		t1 = new Term(1.0, 3);
		t2 = new Term(-3.0, 3);
		t1.plus(t2);
		assertEquals(-2.0, t1.getCoef(), 0.00005);
		t1 = new Term(-1.0, 3);
		t2 = new Term(-1.0, 3);
		t1.plus(t2);
		assertEquals(-2.0, t1.getCoef(), 0.00005);
		t1 = new Term(1.0, 3);
		t2 = new Term(1.0, 3);
		t1.plus(t2);
		assertEquals(2.0, t1.getCoef(), 0.00005);
	}

	/**
	 * Tests the times function in the terms class.
	 */
	@Test
	public void testTimes() {
		Term t1 = new Term(2.0, 3);
		Term t2 = new Term(-2.0, 3);
		t1.times(t2);
		assertEquals("positive * negative: coefficient", -4.0, t1.getCoef(),
				0.00005);
		assertEquals("positive * negative: exponent", t1.getExp(), 6);
		t1 = new Term(0.0, 3);
		t2 = new Term(2.0, 3);
		t1.times(t1);
		assertEquals("0 * something else: coefficient", 0.0, t1.getCoef(),
				0.00005);
		t1 = new Term(8.0, 3);
		t2 = new Term(4.0, 3);
		t1.times(t2);
		assertEquals("positive * positive: coefficient", 32.0, t1.getCoef(),
				0.00005);
		assertEquals("positive * positive: exponent", 6, t1.getExp());
		t1 = new Term(-2.0, 3);
		t2 = new Term(-3.0, 3);
		t1.times(t2);
		assertEquals("negative * negative: coefficient", 6.0, t1.getCoef(),
				0.00005);
		assertEquals("negative * negative: exponent", 6, t1.getExp());
	}

	@Test
	public void testToString() {
		Term t1 = new Term(2.0, 0);
		Term t2 = new Term(-2.0, 1);
		Term t3 = new Term(-2.0, 3);
		assertEquals("2.000000", t1.toString());
		assertEquals("-2.000000x", t2.toString());
		assertEquals("-2.000000x^3", t3.toString());
	}

}
