package de.unistuttgart.vis.dsass2020.ex04.p3;

/**
 * Do not modify this class.
 */
public class BinaryTreeNode<T extends Comparable<T>> implements IBinaryTreeNode<T> {
	
	private volatile T value;
	private volatile IBinaryTreeNode<T> leftChild;
	private volatile IBinaryTreeNode<T> rightChild;
	
	public BinaryTreeNode() {
		this.value = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	@Override
	public void setValue(T val) {
		this.value = val;
	}

	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setLeftChild(IBinaryTreeNode<T> left) {
		this.leftChild = left;
	}

	@Override
	public IBinaryTreeNode<T> getLeftChild() {
		return this.leftChild;
	}
	
	@Override
	public void setRightChild(IBinaryTreeNode<T> right) {
		this.rightChild = right;
	}

	@Override
	public IBinaryTreeNode<T> getRightChild() {
		return this.rightChild;
	}

}
