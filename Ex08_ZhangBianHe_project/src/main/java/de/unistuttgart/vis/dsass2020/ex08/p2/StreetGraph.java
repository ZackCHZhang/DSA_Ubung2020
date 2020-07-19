package de.unistuttgart.vis.dsass2020.ex08.p2;

import de.unistuttgart.vis.dsass2020.ex08.p2.MetaData.JunctionDetails;
import de.unistuttgart.vis.dsass2020.ex08.p2.MetaData.StreetDetails;

/**
 * WeightedGraph for modeling a transportation network.
 * Nodes represent junctions ({@link JunctionDetails}), 
 * and edges represent street segments ({@link StreetDetails}).
 */
public class StreetGraph extends WeightedGraph<JunctionDetails, StreetDetails> {

	public StreetGraph() {
		super(0);
	}

	public void addEdge(int src, int dst, StreetDetails metaData){
		double weight = calcWeight(src, dst, metaData, this);
		addEdge(new Street(src, dst, weight, metaData));
		if (!metaData.oneway) {
			addEdge(new Street(dst, src, weight, metaData));	
		}
	}
	
	public static class Street extends Edge<StreetDetails> {
		
		private Street(int src, int dst, double weight, StreetDetails metaData){
			super(src, dst, weight);
			setMetaData(metaData);
		}
		
		@Override
		public String toString() {
			String street = getMetaData().highway;
			if(!getMetaData().name.isEmpty())
				street = street += " (" + getMetaData().name + ")";
			return String.format("{%d --> %d via %s}", getSource(), getDestination(), street);
		}
	}
	
	/**
	 * Calculates the weight of an edge from <tt>src</tt> to <tt>dst</tt> 
	 * in the specified graph while taking into account the provided metadata
	 * of the street segment that the edge represents.
	 * 
	 * PRECONDITION: All nodes are already inserted into the graph.
	 * 
	 * @param src source node in g
	 * @param dst destination node in g
	 * @param metaData street segment details
	 * @param g graph
	 * @return the weight for the edge
	 */
	static double calcWeight(int src, int dst, StreetDetails metaData, StreetGraph g){
		// weight is edge length (travel distance for edge)
		// 1 mile = 1.609344 km;
		return metaData.length * 1.609344;
	}
	

}
