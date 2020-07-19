package de.unistuttgart.vis.dsass2020.ex08.p2;

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

	/**
	 * Returns an iterator for all outgoing edges of the current node
	 * 
	 * @param src the node id, for which to get outgoing edges
	 * @return iterator for all outgoing edges of node source.
	 */
	public Iterator<IEdge<E>> outgoingEdges(int src);

	@Override
	default Iterator<IEdge<E>> iterator() {
		return edgeIterator();
	}
}
