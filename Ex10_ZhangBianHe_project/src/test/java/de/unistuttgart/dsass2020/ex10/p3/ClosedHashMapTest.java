package de.unistuttgart.dsass2020.ex10.p3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.unistuttgart.dsass2020.ex10.p3.ClosedHashMap;
import de.unistuttgart.dsass2020.ex10.p3.AbstractHashMap.KeyValuePair;

public class ClosedHashMapTest {

	ClosedHashMap<Integer> testClosedHashMap=new ClosedHashMap(10,1);
	@Test
	public void testHashMap() {
		this.testClosedHashMap.put(42, 0);
		this.testClosedHashMap.put(64, 1);
		this.testClosedHashMap.put(34, 2);
		this.testClosedHashMap.put(119, 3);
		this.testClosedHashMap.put(69, 4);
		this.testClosedHashMap.put(29, 5);
		
		for(KeyValuePair<Integer> iterKVP :this.testClosedHashMap) {
			System.out.println(iterKVP);
		}
		
		assertEquals(3,(int)this.testClosedHashMap.get(119));
	}
	
}
