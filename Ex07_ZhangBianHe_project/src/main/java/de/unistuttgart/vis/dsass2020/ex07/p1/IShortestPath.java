package de.unistuttgart.vis.dsass2020.ex07.p1;

import java.util.Iterator;

public interface IShortestPath<N,E> {

  /**
   * Computes the Bellman Ford algorithm on the weighted graph <tt>graph</tt>
   * from starting node <tt>startnode</tt>. This method is started after
   * initializing a ShortPath object.
   * 
   * @param graph       the weighted graph
   * @param startnode the starting node
   */
  public void bellmanFord(IWeightedGraph<N,E> graph, int startnode);

  /**
   * Returns a boolean whether there is a negative cycle reachable from the
   * starting node <tt>startnode</tt>
   * 
   * @return <tt>true</tt> if there is a negative cycle reachable from the
   *         starting node <tt>startnode</tt>, and <tt>false</tt> otherwise
   */
  public boolean hasNegativeCycle();

  /**
   * Returns the distance of the shortest path from the starting node
   * <tt>startnode</tt> to node <tt>destination</tt>.
   * (Distance in terms of edge weights)
   * 
   * @param destination the destination node
   * @return the length (weight) of a shortest path from the starting node
   *         <tt>startnode</tt> to node <tt>destination</tt>;
   *         <tt>Double.POSITIVE_INFINITY</tt> if no such path exists
   * @throws IllegalStateException if there is a negative cost cycle reachable
   *                               from the starting node <tt>startnode</tt>
   */
  public double distanceTo(int destination);

  /**
   * Returns a boolean whether there is a path from the starting node
   * <tt>startnode</tt> to node <tt>destination</tt>?
   * 
   * @param destination the destination node
   * @return <tt>true</tt> if there is a path from the starting node
   *         <tt>startnode</tt> to node <tt>destination</tt>, and
   *         <tt>false</tt> otherwise
   */
  public boolean existsPathTo(int destination);

  /**
   * Returns the edges of the shortest path from the starting node
   * <tt>startnode</tt> to node <tt>destination</tt>.
   * Example: A path exists <tt>s--->u--->x--->y</tt> then the iterable will
   * begin with the edge from node <tt>s</tt> to node <tt>u</tt>, then the
   * edge from node <tt>u</tt> to node <tt>x</tt> and then the edge from
   * node <tt>x</tt> to node <tt>y</tt>.
   * 
   * @param destination the destination node
   * @return a shortest path from the starting node <tt>startnode</tt> to
   *         node <tt>destination</tt> in as an iterable of the
   *         edges, and <tt>null</tt> if no such path exists
   * @throws IllegalStateException if there is a negative cost cycle reachable
   *                               from the starting node <tt>startnode</tt>
   */
  public Iterable<IEdge<E>> pathTo(int destination);

}
