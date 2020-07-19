package de.unistuttgart.vis.dsass2020.ex07.p1;

import java.util.Iterator;

public interface IWeightedGraph<N,E> extends Iterable<IEdge<E>> {

	/**
	 * Returns the number of edges in the weighted graph.
	 * 
	 * @return the number of edges in the weighted graph
	 */
	public int numberOfEdges();

	/**
	 * Returns the number of vertices in the weighted graph.
	 * 
	 * @return the number of vertices in the weighted graph
	 */
	public int numberOfNodes();

	/**
	 * Returns the meta data of the node with specified index.
	 * 
	 * @param nodeIdx id of the node
	 * @return node meta data for index
	 */
	public N getNodeMetaData(int nodeIdx);

	/**
	 * Returns an iterator of all edges in the weighted graph.
	 * 
	 * @return an iterator that iterates through all edges in the weighted graph.
	 */
	public Iterator<IEdge<E>> edgeIterator();


	@Override
	default Iterator<IEdge<E>> iterator() {
		return edgeIterator();
	}
}
