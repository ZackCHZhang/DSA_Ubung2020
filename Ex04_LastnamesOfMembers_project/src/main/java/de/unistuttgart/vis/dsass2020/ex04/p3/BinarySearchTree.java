package de.unistuttgart.vis.dsass2020.ex04.p3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTreeIterable<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}
		if (t.compareTo(node.getValue()) < 0) {
			node.setLeftChild(this.insert(node.getLeftChild(), t));
		} else if (t.compareTo(node.getValue()) > 0) {
			node.setRightChild(this.insert(node.getRightChild(), t));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	class PreorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {
		java.util.Stack<IBinaryTreeNode<T>> st = new java.util.Stack<IBinaryTreeNode<T>>();

		public PreorderIterator(BinarySearchTree<T> tree) {
			if (tree.getRootNode() != null)
				st.push(tree.getRootNode());
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !st.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			IBinaryTreeNode<T> node = st.pop();
			T obj = node.getValue();
			if (node.getRightChild() != null)
				st.push(node.getRightChild());
			if (node.getLeftChild() != null)
				st.push(node.getLeftChild());
			return obj;
		}

	}

	class InorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {
		private IBinaryTreeNode<T> root;
		java.util.Stack<IBinaryTreeNode<T>> st = new java.util.Stack<IBinaryTreeNode<T>>();

		public InorderIterator(IBinarySearchTree<T> tree) {
			this.root = tree.getRootNode();

		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (!st.isEmpty()||root!=null) ;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			while (this.hasNext()) {
				if (root != null) {
					st.push(root);
					root = root.getLeftChild();
				} else {
					root = st.pop();
					T obj = root.getValue();
					root = root.getRightChild();
					return obj;
				}
			}
			return null;
		}

	}

	class PostorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {
		private IBinaryTreeNode<T> root;
		private IBinaryTreeNode<T> nextNode;
		private IBinaryTreeNode<T> prevNode;
		java.util.Stack<IBinaryTreeNode<T>> st = new java.util.Stack<IBinaryTreeNode<T>>();

		public PostorderIterator(IBinarySearchTree<T> tree) {
			this.root = tree.getRootNode();
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (!st.isEmpty()||root!=null) ;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			while (this.hasNext()) {
				if (root != null) {
					st.push(root);
					root = root.getLeftChild();
				} else {
					nextNode = st.peek();
					if (nextNode.getRightChild() != null && prevNode != nextNode.getRightChild()) {
						root = nextNode.getRightChild();
					} else {
						prevNode = st.pop();
						return nextNode.getValue();
					}

				}
			}
			return null;
		}

	}

	class LevelorderIterator<T extends Comparable<T>> implements java.util.Iterator<T> {
		private Queue<IBinaryTreeNode<T>> queue = new LinkedList<IBinaryTreeNode<T>>();
		private IBinaryTreeNode<T> root;

		public LevelorderIterator(BinarySearchTree<T> tree) {
			queue.add(tree.getRootNode());
			root = tree.getRootNode();

		}

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !queue.isEmpty();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			while (this.hasNext()) {
				root = queue.poll();
				if (root.getLeftChild() != null)
					queue.add(root.getLeftChild());
				if (root.getRightChild() != null)
					queue.add(root.getRightChild());
				return root.getValue();
			}
			return null;
		}

	}

	@Override
	public Iterator<T> iterator(TreeTraversalType traversalType) {
		// TODO Auto-generated method stub
		switch (traversalType) {
		case PREORDER:
			return new PreorderIterator(this);
		case POSTORDER:
			return new PostorderIterator(this);
		case INORDER:
			return new InorderIterator(this);
		case LEVELORDER:
			return new LevelorderIterator(this);
		}
		return null;
	}

}
