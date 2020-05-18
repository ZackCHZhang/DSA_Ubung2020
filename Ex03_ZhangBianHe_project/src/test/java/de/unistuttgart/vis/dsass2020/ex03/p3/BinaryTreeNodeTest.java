package de.unistuttgart.vis.dsass2020.ex03.p3;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2020.ex03.p3.BinaryTreeNode;
import de.unistuttgart.vis.dsass2020.ex03.p3.IBinaryTreeNode;

public class BinaryTreeNodeTest {
private IBinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>();
private IBinaryTreeNode<Integer> test=new BinaryTreeNode<Integer>();
@Test
public void testTree() {
	test=root;
	for(int i=0;i<7;i++) {
		root.setValue(i);
		IBinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>();
		root.setLeftChild(newNode);
		root=root.getLeftChild();
	}
	for(int i=0;i<7;i++) {
		assertEquals(i,(int)test.getValue());
		test=test.getLeftChild();
	}
}

}
