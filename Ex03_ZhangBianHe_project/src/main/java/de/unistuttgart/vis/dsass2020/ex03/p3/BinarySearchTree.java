package de.unistuttgart.vis.dsass2020.ex03.p3;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {
	private IBinaryTreeNode<T> root;
	
	public BinarySearchTree() {
		// TODO: to be completed
		root=new BinaryTreeNode<T>();
	}

	@Override
	public void insert(T t) {
		// TODO Auto-generated method stub
		IBinaryTreeNode<T> newNode=new BinaryTreeNode<T>();
		newNode.setValue(t);
		root= this.insertRekur(root, newNode);
		
	}
	
	public IBinaryTreeNode<T> insertRekur(IBinaryTreeNode<T> root,IBinaryTreeNode<T> node){
		if(root==null||root.getValue()==null) {
			return node;
		}else if(root.getValue().compareTo(node.getValue())>0){
			root.setLeftChild(insertRekur(root.getLeftChild(),node));
		}else if(root.getValue().compareTo(node.getValue())<0) {
			root.setRightChild(insertRekur(root.getRightChild(),node));
		}else
			;	
		return root;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		// TODO Auto-generated method stub
		return this.root;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.isFullRekur(root);
	}
	
	public boolean isFullRekur(IBinaryTreeNode<T> tree) {
		if(root!=null) {
			if(root.getRightChild()==null&&root.getRightChild()==null) {
				return true;
			}
			if(root.getRightChild()!=null&&root.getLeftChild()!=null) {
				return isFullRekur(tree.getLeftChild()) && isFullRekur(tree.getRightChild());
			}
		}
		return false;
	}


}
