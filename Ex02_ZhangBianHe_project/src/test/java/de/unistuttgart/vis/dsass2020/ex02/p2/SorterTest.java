package de.unistuttgart.vis.dsass2020.ex02.p2;

import static org.junit.Assert.*;

import org.junit.Test;

import de.unistuttgart.vis.dsass2020.ex02.p2.ISimpleList;
import de.unistuttgart.vis.dsass2020.ex02.p2.Sorter;

public class SorterTest {
	private SimpleList<Integer> list1=new SimpleList();
	private SimpleList<Integer> list2=new SimpleList();
	private SimpleList<Integer> list3=new SimpleList();
	public int[] arr= {6,0,8,3,9,2}	;
	public int[] arrSorted= {0,2,3,6,8,9};
	@Test
	public void TestBubbleSort() {
		for(int i=0;i<6;i++) {
			list1.append(arr[i]);
		}
		Sorter.bubbleSort(list1);
		for(int i=0;i<6;i++) {
			assertEquals(arrSorted[i],(int)list1.get(i));
		}
	}
	
	@Test
	public void TestSelsectionSort() {
		for(int i=0;i<6;i++) {
			list2.append(arr[i]);
		}
		Sorter.selectionSort(list2);
		for(int i=0;i<6;i++) {
			assertEquals(arrSorted[i],(int)list2.get(i));

		}
	}
	
	@Test
	public void TestInsertSort() {
		for(int i=0;i<6;i++) {
			list3.append(arr[i]);
		}
		Sorter.insertionSort(list3);
		for(int i=0;i<6;i++) {
//			System.out.println(list.get(i));
			assertEquals(arrSorted[i],(int)list3.get(i));
		}
	}
	
}
