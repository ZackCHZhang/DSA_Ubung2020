package de.unistuttgart.vis.dsass2020.ex04.p2;

public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {
	private ILinkedListNode<T> head = new LinkedListNode<T>();

	public CircularLinkedList() {
		head = new LinkedListNode<T>();
	}

	public boolean isEmpty() {
		return head.getNext() == null;
	}

	@Override
	public void append(T element) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			ILinkedListNode<T> Node = new LinkedListNode<T>();
			Node.setElement(element);
			head.setNext(Node);
			Node.setNext(Node);
			Node.setPrev(Node);
		} else {
			ILinkedListNode<T> firstNode = new LinkedListNode<T>();
			ILinkedListNode<T> currNode = new LinkedListNode<T>();
			firstNode = head.getNext();
			currNode = firstNode.getNext();
			while (currNode.getNext() != firstNode) {
				currNode = currNode.getNext();
			}
			ILinkedListNode<T> newNode = new LinkedListNode<T>();
			newNode.setElement(element);
			newNode.setNext(firstNode);
			newNode.setPrev(currNode);
			currNode.setNext(newNode);

		}
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		ILinkedListNode<T> itNode=new LinkedListNode<T>();
		itNode=head.getNext();
		while(index!=0) {
			if(index>0) {
				itNode=itNode.getNext();
				index--;
			}else {
				itNode=itNode.getPrev();
				index++;
			}
		}
		return itNode.getElement();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		ILinkedListNode<T> fastPointer=new LinkedListNode<T>();
		ILinkedListNode<T> slowPointer=new LinkedListNode<T>();
		fastPointer=head.getNext().getNext();
		slowPointer=head.getNext();
		int length=1;
		while(fastPointer!=slowPointer) {
			fastPointer=fastPointer.getNext().getNext();
			slowPointer=slowPointer.getNext();
			length++;
		}
		return length;
	}

	@Override
	public ILinkedListNode<T> getHead() {
		return head.getNext();
	}

}
