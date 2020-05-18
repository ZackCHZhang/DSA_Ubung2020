package de.unistuttgart.vis.dsass2020.ex04.p2;

public interface ILinkedListNode<T extends Comparable<T>> {
	
	/*
	 * Returns the element stored in the node
	 * 
	 * @return element stored in the node
	 */
	public T getElement();
	
	/*
	 * Set element of the node
	 * 
	 * @param element element to be stored
	 */
	public void setElement(T element);
	
	/*
	 * Returns the next node
	 * 
	 * @return the next node
	 */
	public ILinkedListNode<T> getNext();
	
	/*
	 * Set the reference to the next node
	 * 
	 * @param next the next node
	 */
	public void setNext(ILinkedListNode<T> next);
	
	/*
	 * Returns the previous node
	 * 
	 * @return the previous node
	 */
	public ILinkedListNode<T> getPrev();
	
	/*
	 * Set the reference to the previous node
	 * 
	 * @param prev previous node
	 */
	public void setPrev(ILinkedListNode<T> prev);
}
