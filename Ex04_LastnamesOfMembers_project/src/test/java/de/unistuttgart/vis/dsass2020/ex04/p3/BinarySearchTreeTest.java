package de.unistuttgart.vis.dsass2020.ex04.p3;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2020.ex03.p3.BinarySearchTree;
import de.unistuttgart.vis.dsass2020.ex03.p3.BinaryTreeNode;
import de.unistuttgart.vis.dsass2020.ex03.p3.IBinarySearchTree;
import de.unistuttgart.vis.dsass2020.ex03.p3.IBinaryTreeNode;

public class BinarySearchTreeTest {
	private BinarySearchTree<Integer> test= new BinarySearchTree<Integer>();
	
	@Test
	public void testIt() {
		test.insert(5);
		test.insert(3);
		test.insert(7);
		test.insert(2);
		test.insert(4);
		test.insert(6);
		test.insert(8);
		/*
		 * The Struct of Test tree
		 * 			5
		 * 		/		\
		 * 		3		7
		 * 	/	\		/	\
		 * 2	4		6	8
		 * 
		 * preOrder:5,3,2,4,7,6,8
		 * Inorder:2,3,4,5,6,7,8
		 * PostOrder:2,4,3,6,8,7,5
		 * 
		 * */
		int[] preOrder= {5,3,2,4,7,6,8};
		Iterator Iter=test.iterator(TreeTraversalType.PREORDER);
		int i=0;
		while(Iter.hasNext()) {
			assertEquals(preOrder[i],Iter.next());
			i++;
		}
		Iterator Iter1=test.iterator(TreeTraversalType.INORDER);
		int[] inOrder= {2,3,4,5,6,7,8};
		i=0;
		while(Iter1.hasNext()) {
			assertEquals(inOrder[i],Iter1.next());
//			System.out.println(Iter1.next());
			i++;
		}
		
		System.out.println("_____________________");
		
		Iterator Iter2=test.iterator(TreeTraversalType.POSTORDER);
		int[] postOrder= {2,4,3,6,8,7,5};
		i=0;
		while(Iter2.hasNext()) {
			assertEquals(postOrder[i],Iter2.next());
//			System.out.println(Iter2.next());
			i++;
		}
		
		System.out.println("_____________________");
		
		Iterator Iter3=test.iterator(TreeTraversalType.LEVELORDER);
		int[] levelOrder= {5,3,7,2,4,6,8};
		i=0;
		while(Iter3.hasNext()) {
			assertEquals(levelOrder[i],Iter3.next());
			i++;
//			System.out.println(Iter3.next());
		}
		
	}

}
