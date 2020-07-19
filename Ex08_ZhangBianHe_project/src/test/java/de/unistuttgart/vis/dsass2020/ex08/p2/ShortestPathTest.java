package de.unistuttgart.vis.dsass2020.ex08.p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;



public class ShortestPathTest {

	public WeightedGraph<String,String> testGraph= GraphLoader.loadExampleGraph();
	@Test
	public void test() {
		ShortestPath<String, String> sp=new ShortestPath<String, String>(testGraph,0);
		
		Iterator iter=sp.pathTo(6).iterator();
		while(iter.hasNext()) {
			IEdge it= (IEdge) iter.next();
			System.out.println(it.getMetaData());
		}
		System.out.println(sp.distanceTo(7));
		
	}
}
