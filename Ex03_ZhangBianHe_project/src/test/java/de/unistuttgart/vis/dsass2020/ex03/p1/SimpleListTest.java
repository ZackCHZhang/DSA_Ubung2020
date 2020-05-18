package de.unistuttgart.vis.dsass2020.ex03.p1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2020.ex03.p1.ISimpleListIterable;
import de.unistuttgart.vis.dsass2020.ex03.p1.SimpleList;

public class SimpleListTest {
	private SimpleList<Integer> list=new SimpleList<Integer>();
	public void testInit(int n) {
		for(int i=0;i<n;i++) {
			this.list.append(i);
		}
	}
	
	@Test
	public void testItera() {
		int lang=10;
		this.testInit(lang);
		Iterator iter=list.iterator();
		int i=0;
		while(iter.hasNext()&&i<lang-1) {
			assertEquals(i,(int)iter.next());
//			System.out.println(i);
			System.out.println(iter);
			i++;
		}
		Iterator skippIter=list.skippingIterator(2);
		i=0;
		while(skippIter.hasNext()&&i<lang-2) {
			assertEquals(i,(int)skippIter.next());
//			System.out.println(i);
//			System.out.println(skippIter.next());
			i+=2;
		}
	}
	
}
