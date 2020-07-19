package de.unistuttgart.vis.dsass2020.ex07.p1;

import java.net.URL;

import de.unistuttgart.vis.dsass2020.ex07.p1.MetaData.JunctionDetails;
import de.unistuttgart.vis.dsass2020.ex07.p1.MetaData.StreetDetails;


public class BirminghamRoutePlanning {

 
	
	public static void main(String[] args) {
		StreetGraph g = GraphLoader.loadBirminghamStreetGraph();
		System.out.println("nodes " + g.numberOfNodes() + "  edges " + g.numberOfEdges());
		
		ShortestPath<JunctionDetails, StreetDetails> sp= new ShortestPath<JunctionDetails, StreetDetails>((IWeightedGraph)g, MetaData.NODE_GURLEY_CIRCLE);
		System.out.println("At least u need  "+sp.distanceTo(MetaData.NODE_UNIVERSITY) +"mins to go to univercity");
		System.out.println("At least u need "+sp.distanceTo(MetaData.NODE_ALABAMA_THEATRE)+"mins to go to Theatre");
		System.out.println("At least u need "+sp.distanceTo(MetaData.NODE_AIRPORT)+ "mins to go to Airport");
		System.out.println("At least u need "+sp.distanceTo(MetaData.NODE_HEALTH_CENTER)+"mins to go to Health Center");
		
		
	}
	
	

	

}
