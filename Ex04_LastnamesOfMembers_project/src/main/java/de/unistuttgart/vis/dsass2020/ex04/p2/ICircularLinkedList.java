package de.unistuttgart.vis.dsass2020.ex04.p2;

public interface ICircularLinkedList<T extends Comparable<T>> {
	/*
	 * Append element to the end of the list
	 * 
	 * @param element element to be appended
	 */
	public void append(T element);

	/*
	 * Returns the element at the specified position
	 * 
	 * @param index index of the element starting from 0. If the index is larger
	 * than the number of elements in the list, the method loops back to the
	 * first element and continues in a circular manner. If the index is
	 * negative, it returns the element in the opposite direction (index -1
	 * returns the last element, index -2 returns the second to last element,
	 * and so on).
	 */
	public T get(int index);

	/*
	 * Returns the number of elements in the list
	 * 
	 * @return number of elements in the list
	 */
	public int size();

	/*
	 * Returns the head node (first node) of the list
	 * 
	 * @return head node of the list
	 */
	public ILinkedListNode<T> getHead();
}
