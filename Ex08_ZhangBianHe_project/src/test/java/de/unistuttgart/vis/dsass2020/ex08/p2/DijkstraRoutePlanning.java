package de.unistuttgart.vis.dsass2020.ex08.p2;

import de.unistuttgart.vis.dsass2020.ex07.p1.IWeightedGraph;
import de.unistuttgart.vis.dsass2020.ex07.p1.MetaData;
import de.unistuttgart.vis.dsass2020.ex07.p1.ShortestPath;
import de.unistuttgart.vis.dsass2020.ex08.p2.MetaData.JunctionDetails;
import de.unistuttgart.vis.dsass2020.ex08.p2.MetaData.StreetDetails;


public class DijkstraRoutePlanning {
	
	public static void main(String[] args) {
		StreetGraph g = GraphLoader.loadBirminghamStreetGraph();
		System.out.println("nodes " + g.numberOfNodes() + "  edges " + g.numberOfEdges());
		ShortestPath<JunctionDetails, StreetDetails> sp= new ShortestPath<JunctionDetails, StreetDetails>((IWeightedGraph)g, MetaData.NODE_UNIVERSITY);
		ShortestPath<JunctionDetails, StreetDetails> sp1= new ShortestPath<JunctionDetails, StreetDetails>((IWeightedGraph)g, MetaData.NODE_HEALTH_CENTER);
		
//		System.out.println("At least u need  "+sp.distanceTo(MetaData.NODE_AIRPORT) +"mins to go to univercity");
		
		System.out.println(sp1.closestPointsBetween(sp, 1));
	}

	

}
