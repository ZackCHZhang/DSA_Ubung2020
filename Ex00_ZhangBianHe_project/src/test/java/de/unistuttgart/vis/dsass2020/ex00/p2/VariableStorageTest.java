package de.unistuttgart.vis.dsass2020.ex00.p2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


/**
 * You should use this class to test your class {@link VariableStorage}, using
 * JUnit assertions like {@link Assert#assertEquals(Object, Object)}. For
 * additional information on how to test your code with JUnit visit 
 * http://www.vogella.com/tutorials/JUnit/article.html
 */
public class VariableStorageTest {

	/**
	 * Just create additional tests by creating new methods according to 
	 * this pattern.
	 * 
	 *  For an example see also {@link CalculatorTest#testAdd()}.
	 */
	@Test
	public void test() {
		/* Here you should do something with the tested class and compare
		 * obtained results with expected results. */
		final int resultObtainedFromClass = 1;
		final int expectedResults = 1;
		final IVariableStorage<Integer> Ivs=new VariableStorage<Integer>();
		assertEquals(expectedResults, resultObtainedFromClass);
		Ivs.set(expectedResults);
		assertEquals(expectedResults,(int)Ivs.get());
		assertEquals(expectedResults,(int)Ivs.get());
		
	}

	// Add your test methods here
	@Test
	public void testNull() {
		final IVariableStorage<?> Ivs=new VariableStorage<Object>();
		assertEquals(null,Ivs.get());
	}
	
}
