package de.unistuttgart.vis.dsass2020.ex03.p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {

	/** Do not modify the existing methods and signatures */
	private final List<T> list;

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

	private class simpleIterator implements Iterator<T> {
		private int index;

		public simpleIterator() {
			index = 0;
		}

		public boolean hasNext() {
			return !(list.get(index) == null);
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			index++;
			return list.get(index - 1);
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class skippingIterator implements Iterator<T>{
		private int index;
		private int step=1;
		public skippingIterator(int s) {
			index=0;
			step=s;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !(list.get(index)==null);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!this.hasNext())
				throw new NoSuchElementException();
			index+=step;
			return list.get(index-step);
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new simpleIterator();
	}

	@Override
	public Iterator<T> skippingIterator(int n) {
		// TODO Auto-generated method stub
		return new skippingIterator(n);
	}

}
