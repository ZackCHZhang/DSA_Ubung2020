package de.unistuttgart.vis.dsass2020.ex03.p1;

import java.util.Iterator;

/**
 * An iterator over a collection
 * 
 * @param <T> The type of elements returned by this iterator
 */
public interface ISimpleListIterable<T extends Comparable<T>> extends ISimpleList<T> {
	
	/**
	* Returns an iterator that enumerates every
	* element in the collection, starting with the
	* first element.
	*
	* @return the iterator.
	*/
	public Iterator<T> iterator();
	
	/**
	* Returns an iterator that enumerates every n-th
	* element in the collection, starting with the
	* first element.
	*
	* @param n the number of skipped elements+1.
	* @return the iterator.
	* @throws IllegalArgumentException if n is less than 1.
	*/
	public Iterator<T> skippingIterator(int n);
}
