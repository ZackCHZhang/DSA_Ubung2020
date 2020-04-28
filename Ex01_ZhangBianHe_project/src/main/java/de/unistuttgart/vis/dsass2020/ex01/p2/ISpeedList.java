package de.unistuttgart.vis.dsass2020.ex01.p2;

/**
 * A simple list interface
 * 
 * @param <T>
 *            The type of list element
 */
public interface ISpeedList<T> {

	/**
	 * Returns the current number of elements in the list
	 * 
	 * @return Current number of elements in the list
	 */
	public int size();

	/**
	 * Inserts an element at the beginning of the list
	 * 
	 * @param item
	 *            Item to be inserted
	 */
	public void prepend(T t);

	/**
	 * Inserts an element at the end of the list
	 * 
	 * @param item
	 *            Item to be inserted
	 */
	public void append(T t);
	
	/**
	 * Returns the element at the specified position in the list
	 * 
	 * @param pos
	 *            The position of the element in the list starting from 0
	 * 
	 * @return The specified element in the list
	 * @throws Exception 
	 * 
	 * @throws IndexOutOfBoundsException
	 *             If the requested element is out of range
	 */
	public T getElementAt(int pos) throws Exception;
}
