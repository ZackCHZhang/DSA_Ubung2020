package de.unistuttgart.vis.dsass2020.ex03.p3;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2020.ex03.p3.BinarySearchTree;
import de.unistuttgart.vis.dsass2020.ex03.p3.BinaryTreeNode;
import de.unistuttgart.vis.dsass2020.ex03.p3.IBinarySearchTree;
import de.unistuttgart.vis.dsass2020.ex03.p3.IBinaryTreeNode;

public class BinarySearchTreeTest {
private IBinarySearchTree<Integer> test= new BinarySearchTree<Integer>();
IBinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>();
@Test 
public void testBST() {
//	IBinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>();
	int[] testArray= {5,3,7,2,4,6,8};
	for(int i=0;i<3;i++) {
		
	}
	
	test.insert(5);
	test.insert(3);
	test.insert(7);
	test.insert(2);
	test.insert(4);
	test.insert(6);
	test.insert(8);
	root=test.getRootNode();
	System.out.println(root.getValue());
	assertEquals(5,(int)root.getValue());
	root=root.getLeftChild();
	assertEquals(3,(int)root.getValue());
	root=root.getRightChild();
	assertEquals(4,(int)root.getValue());
}


}
