package de.unistuttgart.vis.dsass2020.ex00.p1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * You should use this class to test your class {@link Calculator}, using JUnit
 * assertions like {@link Assert#assertEquals(Object, Object)}. For additional
 * information on how to test your code with JUnit visit
 * http://www.vogella.com/tutorials/JUnit/article.html
 */
public class CalculatorTest {

	/**
	 * Just create additional tests by creating new methods according to this
	 * pattern.
	 */
	@Test
	public void testAdd() {
		final ICalculator cal = new Calculator();
		assertEquals(2 + 5, cal.add(2, 5));
		assertEquals(3 + 4, cal.add(3, 4));
	}

	// Add your test methods here
	@Test
	public void testMult() {
		final ICalculator cal = new Calculator();
		assertEquals(2 * 5, cal.multiply(2, 5));
		assertEquals(188 * 888, cal.multiply(188, 888));
	}

	@Test
	public void testMin() {
		final ICalculator cal = new Calculator();
		assertEquals(2, cal.minimum(2, 5));
		assertEquals(1, cal.minimum(1, 100));
	}

	@Test
	public void testQSum() {
		final ICalculator cal = new Calculator();
		assertEquals(3, cal.quersumme(111));
		assertEquals(10, cal.quersumme(1234));
	}
}
