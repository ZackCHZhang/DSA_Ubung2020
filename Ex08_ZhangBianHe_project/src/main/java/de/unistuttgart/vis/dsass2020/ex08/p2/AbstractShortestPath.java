package de.unistuttgart.vis.dsass2020.ex08.p2;

import java.util.Set;

public abstract class AbstractShortestPath<N,E> implements IShortestPath<N, E> {
	/**
     * Calculates the points that are in the middle of both ShortestPath instances.
     *  
     * @param o the other ShortestPath instance of another point
     * @param count the amount of node IDs to return
     * @return a set of node IDs that are between both points
	 */
	public abstract Set<Integer> closestPointsBetween(ShortestPath<N, E> other, int count);
}
