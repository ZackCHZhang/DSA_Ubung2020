package de.unistuttgart.vis.dsass2020.ex04.p3;

import java.util.Iterator;

/**
 * Interface for an iterable {@link IBinarySearchTree}
 */
public interface IBinarySearchTreeIterable<T extends Comparable<T>> extends IBinarySearchTree<T>{
	
	/**
	 * Returns an iterator which traverses the tree given a traversal type 
	 * 
	 * @param traversalType traversal type
	 * @return an iterator which traverses the tree given a traversal type
	 */
	public Iterator<T> iterator(TreeTraversalType traversalType);
	
}
