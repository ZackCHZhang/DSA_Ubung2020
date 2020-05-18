package de.unistuttgart.vis.dsass2020.ex04.p2;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class LinkedListNodeTest {
	@Test
	public void testLinkedNodeTest() {
		ILinkedListNode<Integer> itNode=new LinkedListNode<Integer>();
		ILinkedListNode<Integer> currNode=new LinkedListNode<Integer>();
		ILinkedListNode<Integer> firstNode=new LinkedListNode<Integer>();
		for(int i=0;i<9;i++) {
			itNode.setElement(i);
			ILinkedListNode<Integer> nextNode=new LinkedListNode<Integer>();
			itNode.setNext(nextNode);
			currNode=itNode;
			if(i==0) {
				firstNode=currNode;
			}
			itNode=itNode.getNext();
			itNode.setPrev(currNode);
		}
		itNode.setElement(9);
		itNode.setNext(firstNode);
		itNode=firstNode;
		for(int i=0;i<30;i++) {
			assertEquals((i%10),(int)itNode.getElement());
			System.out.println(itNode.getElement());
			itNode=itNode.getNext();
			
		}
		
	}

}
