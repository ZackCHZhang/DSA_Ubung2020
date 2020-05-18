package de.unistuttgart.vis.dsass2020.ex03.p3;

public interface IBinarySearchTree<T extends Comparable<T>> {

	/**
	 * Inserts a node with the given element into the binary search tree.
	 * If the tree already contains this element, discard the insertion.
	 * 
	 * @param t the element to be inserted
	 */
	public void insert(T t);

	/**
	 * Returns the (true) root node of the binary search tree.
	 * 
	 * @return root node of the tree
	 */
	public IBinaryTreeNode<T> getRootNode();

	/**
	 * Returns a boolean whether the tree is full or not. See slides
	 * "V05_Baeume" page 20 for the definition of a full tree. Here,
	 * "full" refers to the German "voll".
	 *
	 * @return a boolean whether the tree is full
	 */
	public boolean isFull();

}
