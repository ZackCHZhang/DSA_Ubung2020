package de.unistuttgart.vis.dsass2020.ex04.p3;

public interface IBinaryTreeNode<T extends Comparable<T>> {

	/**
	 * Sets the value of the node.
	 * 
	 * @param val value of the node
	 */
	public void setValue(T val);

	/**
	 * Returns the value of the node.
	 * 
	 * @return value of the node
	 */
	public T getValue();

	/**
	 * Sets the left child of the node.
	 * 
	 * @param left left child
	 */
	public void setLeftChild(IBinaryTreeNode<T> left);

	/**
	 * Returns the left child of the node.
	 * 
	 * @return left child of the node
	 */
	public IBinaryTreeNode<T> getLeftChild();

	/**
	 * Sets the right child of the node.
	 * 
	 * @param right right child of the node
	 */
	public void setRightChild(IBinaryTreeNode<T> right);

	/**
	 * Returns the right child of the node.
	 * 
	 * @return right child of the node
	 */
	public IBinaryTreeNode<T> getRightChild();

}
