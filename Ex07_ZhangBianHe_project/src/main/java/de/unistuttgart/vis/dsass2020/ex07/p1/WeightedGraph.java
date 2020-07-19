package de.unistuttgart.vis.dsass2020.ex07.p1;

import java.util.ArrayList;
import java.util.Iterator;

public class WeightedGraph<N,E> implements IWeightedGraph<N,E> {

	private int numNodes;
	private int numEdges;
	private final ArrayList<ArrayList<IEdge<E>>> adjacencyList;
	private final ArrayList<N> nodeMetaData;

	/**
	 * Initializes a weighted graph with <tt>n</tt> nodes and 0 directed
	 * edges.
	 * 
	 * @param n the number of nodes
	 * 
	 * @throws java.lang.IllegalArgumentException if <tt>n</tt> < 0
	 */
	public WeightedGraph(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Number of nodes in a graph must be nonnegative");
		this.numNodes = n;
		this.numEdges = 0;
		this.nodeMetaData = new ArrayList<>(n);
		this.adjacencyList = new ArrayList<>(n);
		for (int i = 0; i < n; i++){
			this.nodeMetaData.add(null);
			this.adjacencyList.add(new ArrayList<>(1));
		}
	}
	
	/**
	 * Initializes an empty graph without nodes and edges.
	 */
	public WeightedGraph() {
		this(0);
	}

	@Override
	public int numberOfNodes() {
		return this.numNodes;
	}

	@Override
	public int numberOfEdges() {
		return this.numEdges;
	}
	
	/**
	 * Adds a new node without meta data to this graph.
	 * @return the new node's index
	 */
	public int addNode(){
		return addNode(null);
	}
	
	/**
	 * Adds a new node with the specified meta data to this graph.
	 * @param nodeMetaData meta data of the added node
	 * @return the new node's index
	 */
	public int addNode(N nodeMetaData){
		this.nodeMetaData.add(nodeMetaData);
		this.adjacencyList.add(new ArrayList<>(1));
		return this.numNodes++;
	}
	
	/**
	 * Adds a new edge from node index <tt>src</tt> to node index <tt>dst</tt>.
	 * @param src index of the source node
	 * @param dst index of the destination node
	 * @param weight weight of the edge
	 * @return the created edge object.
	 */
	public Edge<E> addEdge(int src, int dst, double weight){
		Edge<E> toAdd = new Edge<>(src, dst, weight);
		this.addEdge(toAdd);
		return toAdd;
	}

	/**
	 * Adds the specified edge to this graph.
	 * @param edge to add
	 */
	public void addEdge(IEdge<E> edge) {
		int source = edge.getSource();
		this.adjacencyList.get(source).add(edge);
		this.numEdges++;
	}

	@Override
	public N getNodeMetaData(int nodeIdx) {
		return this.nodeMetaData.get(nodeIdx);
	}
	
	/**
	 * Sets the meta data of the specified node
	 * @param nodeIdx index of the node
	 * @param meta meta data to set
	 */
	public void setNodeMetaData(int nodeIdx, N meta){
		this.nodeMetaData.set(nodeIdx, meta);
	}

	@Override
	public Iterator<IEdge<E>> edgeIterator() {
		ArrayList<IEdge<E>> edgeList = new ArrayList<IEdge<E>>(numEdges);
		for (int i = 0; i < this.numNodes; i++) {
			edgeList.addAll(this.adjacencyList.get(i));
		}
		return edgeList.iterator();
	}

}
