package de.unistuttgart.vis.dsass2020.ex08.p2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortestPath<N, E> extends AbstractShortestPath<N, E> {

	private final IWeightedGraph<N, E> graph;
	private final int startNode;
	private IEdge<E>[] predecessor;
	private LinkedList<IEdge<E>> al = new LinkedList<IEdge<E>>();

	public static class saveData {
		private int id;
		private double distance;

		public saveData(int id, double distance) {
			this.id = id;
			this.distance = distance;
		}

		public String toString() {
			return id + "-" + distance;
		}

		public void setDistance(double a) {
			this.distance = a;
		}
	}

	Comparator<saveData> comparator = new Comparator<saveData>() {
		public int compare(saveData d1, saveData d2) {
			return (int) (d1.distance - d2.distance);
		}
	};

	private PriorityQueue<saveData> q = new PriorityQueue<saveData>(comparator);
	private PriorityQueue<saveData> v = new PriorityQueue<saveData>(comparator);

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
		this.predecessor = new IEdge[graph.numberOfEdges()];
		dijkstra(this.graph, this.startNode);
	}

	@Override
	public void dijkstra(IWeightedGraph<N, E> graph, int startnode) {
		// TODO Auto-generated method stub
		for (int i = 0; i < graph.numberOfNodes(); i++) {
			if (i == startnode) {
				this.q.add(new saveData(i, 0.0));
			} else {
				this.q.add(new saveData(i, Double.POSITIVE_INFINITY));
			}
			this.predecessor[i] = null;
		}

		while (!q.isEmpty()) {
			saveData resort = new saveData(Integer.MAX_VALUE, Double.MAX_VALUE);
			q.add(resort);
			q.remove(resort);
			saveData idx = q.poll();
			System.out.print(idx);
			v.add(idx);

			for (IEdge a : graph) {
				if (a.getSource() == idx.id) {
					for (saveData b : q) {
						if (b.id == a.getDestination()) {
							if (b.distance > idx.distance + a.getWeight()) {
								b.setDistance(idx.distance + a.getWeight());
								this.predecessor[a.getDestination()] = a;

							}
						}

					}
				}
			}

			
		}
	}

	@Override
	public double distanceTo(int destination) {
		// TODO Auto-generated method stub
		double res = Double.NaN;
		for (saveData a : v) {
			if (a.id == destination) {
				res = a.distance;
			}
		}
		return res;
	}

	@Override
	public boolean existsPathTo(int destination) {
		// TODO Auto-generated method stub
		boolean res = false;
		for (saveData a : v) {
			if (a.id == destination) {
				if (a.distance != Double.POSITIVE_INFINITY) {
					res = true;
				}
			}
		}
		return res;
	}

	public void ListStore(int destination) {
		int i = destination;
		while (this.predecessor[i] != null) {
			this.al.addFirst(this.predecessor[i]);
			i = this.predecessor[i].getSource();
		}
	}

	public class pathIter implements Iterator<IEdge<E>> {
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !al.isEmpty();
		}

		@Override
		public IEdge<E> next() {
			// TODO Auto-generated method stub
			IEdge<E> x = al.getFirst();
			al.removeFirst();
			return x;
		}

	}

	class pt implements Iterable<IEdge<E>> {
		private int destination;

		public pt(int destination) {
			this.destination = destination;
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
		this.ListStore(destination);
		return new pt(destination);
	}

	@Override
	public Set<Integer> closestPointsBetween(ShortestPath<N, E> other, int count) {
		// TODO Auto-generated method stub
		Iterator iterPath1 = this.pathTo(other.startNode).iterator();
		Iterator iterPath2 =  other.pathTo(this.startNode).iterator();

		int midPoint=Integer.MAX_VALUE;
		IEdge a = (IEdge) iterPath1.next();
		IEdge b = (IEdge) iterPath2.next();
		
		
		
		while (true) {
			System.out.println(midPoint);
			 a = (IEdge) iterPath1.next();
			 b = (IEdge) iterPath2.next();
			if(a.getDestination()==b.getDestination()||a.getSource()==b.getDestination()||a.getDestination()==b.getSource()) {
				midPoint=a.getDestination();
				break;
			}

		}
		Set<Integer> res = new HashSet();
		
		res.add(midPoint);
		Iterator itSet=res.iterator();
		while(count-1>0) {
			for(IEdge it:graph) {
				if(it.getSource()==midPoint) {
					res.add(it.getDestination());
					count--;
					if(count-1>0) break;
				}
				
				midPoint=(int) itSet.next();
				
			}
			
		}
		return res;
	}

}
