package de.unistuttgart.vis.dsass2020.ex06.p4;

import java.util.ArrayList;
import java.util.List;

/**
 * Do not modify this class
 */
public class SimpleList<T extends Comparable<T>> implements ISimpleList<T> {
	private List<T> list;
	
	public SimpleList() {
		list = new ArrayList<T>();
	}
	
	@Override
	public void append(T element) {
		list.add(element);
	}
	
	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public T get(int index) {
		return list.get(index);
	}
	
	@Override
	public void swap(int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}

}
