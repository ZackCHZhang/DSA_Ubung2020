package de.unistuttgart.vis.dsass2020.ex04.p2;

public class LinkedListNode<T extends Comparable<T>> implements ILinkedListNode<T> {

	private T obj;
	private LinkedListNode<T> next;
	private LinkedListNode<T> pre;

	public void setElement(T obj) {
		this.obj = obj;
	}

	public T getElement() {
		return obj;
	}

	public ILinkedListNode<T> getNext() {
		return this.next;
	}

	public ILinkedListNode<T> getPrev() {
		return this.pre;
	}

	public LinkedListNode() {

	}

	@Override
	public void setNext(ILinkedListNode<T> next) {
		// TODO Auto-generated method stub
		this.next = (LinkedListNode<T>) next;
	}

	@Override
	public void setPrev(ILinkedListNode<T> prev) {
		// TODO Auto-generated method stub
		this.pre = (LinkedListNode<T>) prev;
	}
	
}
