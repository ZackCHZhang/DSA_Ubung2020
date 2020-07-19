package de.unistuttgart.vis.dsass2020.ex06.p4;

import static org.junit.Assert.*;


import org.junit.Test;

import de.unistuttgart.vis.dsass2020.ex06.p4.ISimpleList;
import de.unistuttgart.vis.dsass2020.ex06.p4.Sorter;

public class SorterTest {
	private int[] testArray= {8,3,2,5,9,1};
	private int[] rightArray= {1,2,3,5,8,9};
	private ISimpleList<Integer> testList= new SimpleList<Integer>();
	@Test
	public void test() {
		for (int i = 0; i < testArray.length; i++) {
			testList.append(testArray[i]);
		}
		Sorter.heapSort(testList);
		for(int i=0;i<rightArray.length;i++) {
			System.out.println(testList.get(i));
			assertEquals(rightArray[i],(int)testList.get(i));
		}
	}
	
}
