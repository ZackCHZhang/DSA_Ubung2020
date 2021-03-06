package de.unistuttgart.vis.dsass2020.ex02.p2;

public class Sorter {

	public static <T extends Comparable<T>> void bubbleSort(ISimpleList<T> list) {
		// START SOLUTION
		boolean flag=true;
		int len=list.size();
		while(flag) {
			flag=false;
			for(int i=0;i<len-1;i++) {
				if(list.get(i).compareTo(list.get(i+1))>0) {
					list.swap(i, i+1);
					flag=true;
				}
			}
		}
		// END SOLUTION
	}
		
	public static <T extends Comparable<T>> void selectionSort(ISimpleList<T> list) {
		// START SOLUTION
		  int p=list.size()-1;
		  int j=0;
		  while(j<p) {
		   int minPos=j;
		   for(int i=j+1;i<=p;i++) {
		    if(list.get(i).compareTo(list.get(minPos))<0) {
		     minPos=i;
		    }
		   }
		   list.swap(j, minPos);
		   j++;
		  }
		// END SOLUTION
	}
	
	public static <T extends Comparable<T>> void insertionSort(ISimpleList<T> list) {
		// START SOLUTION
        int len=list.size();
        for(int i=0;i<len;i++) {
        	int j =i;
        	while (j>0){
        		if(list.get(j-1).compareTo(list.get(j))>0){
        			list.swap(j, j-1);
        			j=j-1;
        		}else {
        			break;
        		}
        	}
        }
		// END SOLUTION
	}

}
