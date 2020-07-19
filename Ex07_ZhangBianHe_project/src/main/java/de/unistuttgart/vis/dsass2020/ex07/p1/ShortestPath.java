package de.unistuttgart.vis.dsass2020.ex07.p1;

import java.util.LinkedList;

import java.util.Iterator;

public class ShortestPath<N, E> implements IShortestPath<N, E> {

	private final IWeightedGraph<N, E> graph;
	private final int startNode;
	private double[] D;
	private LinkedList<IEdge<E>> al=new LinkedList<IEdge<E>>();
	private IEdge<E>[] predecessor;

	/*
	 * syntactic sugar function to conveniently create shortest path objects from
	 * graphs
	 */
	public static <N, E> ShortestPath<N, E> calculateFor(IWeightedGraph<N, E> g, int startNode) {
		return new ShortestPath<>(g, startNode);
	}

	/**
	 * Initializes the shortest path for weighted graph <tt>graph</tt> from starting
	 * node <tt>startNode</tt>. Calls the bellmanFord(graph, startNode) method to
	 * execute the Bellman Ford algorithm.
	 * 
	 * @param graph     the weighted graph
	 * @param startNode the starting node
	 */
	public ShortestPath(IWeightedGraph<N, E> graph, int startNode) {
		this.graph = graph;
		this.startNode = startNode;
		this.D=new double[graph.numberOfNodes()];
		this.predecessor=new IEdge[graph.numberOfNodes()];
		bellmanFord(this.graph, this.startNode);
	}

	@Override
	public void bellmanFord(IWeightedGraph<N, E> graph, int startnode) {
		// TODO Auto-generated method stub
		for (int i = 0; i < graph.numberOfNodes(); i++) {
			if (i == startnode) {
				this.D[i] = 0.00;
			} else {
//				System.out.println(i);
				this.D[i] = Double.POSITIVE_INFINITY;
			}
			predecessor[i] = null;
		}

		for (int j = 0; j < graph.numberOfEdges(); j++) {
			Iterator iter=graph.iterator();
			while (iter.hasNext()) {
				
				IEdge<E> iterEdge = (IEdge<E>) iter.next();
				
				if (D[iterEdge.getSource()] + iterEdge.getWeight() < D[iterEdge.getDestination()]) {
					D[iterEdge.getDestination()] = D[iterEdge.getSource()] + iterEdge.getWeight();
					predecessor[iterEdge.getDestination()] = iterEdge;
				}
				
			}
		}
		
		if (this.hasNegativeCycle()) {
			throw new IllegalStateException();
		}
		

	}

	@Override
	public boolean hasNegativeCycle() {
		// TODO Auto-generated method stub
		Iterator iter=graph.iterator();
		while (iter.hasNext()) {
			IEdge<E> iterEdge = (IEdge<E>) iter.next();
			if (D[iterEdge.getSource()] + iterEdge.getWeight() < D[iterEdge.getDestination()])
				return true;
		}
		return false;
	}

	@Override
	public double distanceTo(int destination) {
		// TODO Auto-generated method stub
		if (this.hasNegativeCycle()) {
			throw new IllegalStateException();
		}
		return D[destination];
	}

	@Override
	public boolean existsPathTo(int destination) {
		// TODO Auto-generated method stub
		if (D[destination] < Double.POSITIVE_INFINITY) {
			return true;
		}
		return false;
	}

	public void ListStore(int destination) {
		int i=destination;
		while(this.predecessor[i]!=null) {
			this.al.addFirst(this.predecessor[i]);
			i=this.predecessor[i].getSource();
		}
	}
	
	public class pathIter implements Iterator<IEdge<E>>{
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !al.isEmpty();
		}

		@Override
		public IEdge<E> next() {
			// TODO Auto-generated method stub
			IEdge<E> x=al.getFirst();
			al.removeFirst();
			return x;
		}
		
		
	}
	
	class pt implements Iterable<IEdge<E>>{
		private int destination;


		public pt(int destination) {
			this.destination=destination;
			// TODO Auto-generated constructor stub
		}


		@Override
		public Iterator<IEdge<E>> iterator() {
			return new pathIter();
		}


	}
	
	@Override
	public Iterable<IEdge<E>> pathTo(int destination) {
		// TODO Auto-generated method stub
		if(this.hasNegativeCycle()) {
			throw new IllegalStateException();
		}
		this.ListStore(destination);
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		return new pt(destination);
	}



}
