package de.unistuttgart.vis.dsass2020.ex04.p2;

import static org.junit.Assert.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CircularLinkedListTest {
	private ICircularLinkedList<Integer> testNode= new CircularLinkedList<Integer>();
	
	public void testInit(int gross) {
		for(int i=0;i<gross;i++) {
			testNode.append(i);
		}
	}
	
	@Test
	public void testAll() {
		int gross=10;
		testInit(gross);
		for(int i=0;i<20;i++){
			assertEquals(i%10,(int)this.testNode.get(i));
			System.out.println(testNode.get(i));
		}
		assertEquals(gross,testNode.size());
		assertEquals(0,(int)testNode.getHead().getElement());
	}

}
