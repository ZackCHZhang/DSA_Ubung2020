package de.unistuttgart.vis.dsass2020.ex06.p4;

public class Sorter {

	public static <T extends Comparable<T>> void heapSort(ISimpleList<T> list) {
		int len=list.size();
		for (int i=len/2;i>=0;i--) {
			percolate(list,i,len-1);
		}
		
		for(int i=len-1;i>0;i--) {
			swap(list,0,i);
			percolate(list,0,i-1);
		}

	}
	
	private static <T extends Comparable<T>> void percolate(ISimpleList<T> list,int idx,int last) {
		int i= idx,j;
		while((2*i)+1<=last) {
			j=(2*i)+1;
			if((j+1)<=last) {
				if( list.get(j).compareTo(list.get(j+1))<0) {
					j++;
				}
			}
			if(list.get(i).compareTo(list.get(j))<0) {
				swap(list,i,j);
				i=j;
			}else {
				break;
			}
		}
	}
	
	private static <T extends Comparable<T>> void swap(ISimpleList<T> list,int i1,int i2) {
		list.swap(i1,i2);
	}
}

