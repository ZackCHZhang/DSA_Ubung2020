package de.unistuttgart.vis.dsass2020.ex07.p1;

public class Edge<E> implements IEdge<E> {
	private final int source;
	private final int destination;
	private final double weight;
	private E metaData;

	/**
	 * Initializes a directed edge from vertex <tt>source</tt> to vertex
	 * <tt>dest</tt> with the given <tt>weight</tt>.
	 * 
	 * @param source the tail (source) vertex
	 * @param dest   the head (destination) vertex
	 * @param weight the weight of the directed edge
	 * @throws java.lang.IndexOutOfBoundsException if either <tt>v</tt> or
	 *                                             <tt>w</tt> is a negative
	 *                                             integer
	 * @throws IllegalArgumentException            if <tt>weight</tt> is
	 *                                             <tt>NaN</tt>
	 */
	public Edge(int source, int dest, double weight) {
		if (source < 0)
			throw new IndexOutOfBoundsException(
					"The name of the Vertex must be non negative integers");
		if (dest < 0)
			throw new IndexOutOfBoundsException(
					"The name of the Vertex must be non negative integers");
		if (Double.isNaN(weight))
			throw new IllegalArgumentException("Weight is NaN");
		this.source = source;
		this.destination = dest;
		this.weight = weight;
	}

	@Override
	public int getSource() {
		return source;
	}

	@Override
	public int getDestination() {
		return destination;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public E getMetaData() {
		return metaData;
	}
	
	public Edge<E> setMetaData(E metaData) {
		this.metaData = metaData;
		return this;
	}
	
	@Override
	public String toString() {
		return String.format("{%d --> %d [%s]}", getSource(),getDestination(), getMetaData());
	}
}
