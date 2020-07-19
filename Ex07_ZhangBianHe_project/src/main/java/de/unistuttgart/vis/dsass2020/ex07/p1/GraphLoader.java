package de.unistuttgart.vis.dsass2020.ex07.p1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeMap;

import de.unistuttgart.vis.dsass2020.ex07.p1.MetaData.JunctionDetails;
import de.unistuttgart.vis.dsass2020.ex07.p1.MetaData.StreetDetails;

public class GraphLoader {

	public static StreetGraph loadStreetGraph(URL nodes, URL edges) throws IOException
	{
		try(
				InputStream nfis = nodes.openStream();
				BufferedInputStream nbis = new BufferedInputStream(nfis);
				Scanner nsc = new Scanner(nbis, StandardCharsets.UTF_8.name());
				
				InputStream efis = edges.openStream();
				BufferedInputStream ebis = new BufferedInputStream(efis);
				Scanner esc = new Scanner(ebis, StandardCharsets.UTF_8.name());
		){
			StreetGraph g = new StreetGraph();
			
			int idx=0;
			TreeMap<Long, Integer> id2idx = new TreeMap<>();
			// load nodes
			String line = nsc.nextLine();
			while(nsc.hasNextLine()){
				line = nsc.nextLine().trim();
				if(line.isEmpty())
					continue;
				// fields are osmid;x;y;highway
				String[] fields = line.split(";",-1);
				long osmID = Long.parseLong(fields[0]);
				float x = Float.parseFloat(fields[1]);
				float y = Float.parseFloat(fields[2]);
				String highway = fields[3];
				id2idx.put(osmID, idx++);
				g.addNode(new JunctionDetails(osmID, x, y, highway));
			}
			
			line = esc.nextLine();
			while(esc.hasNextLine()){
				line = esc.nextLine().trim();
				if(line.isEmpty())
					continue;
				// fields are src;dst;oneway;highway;name;length;maxspeed
				String[] fields = line.split(";",-1);
				long src_ = Long.parseLong(fields[0]);
				long dst_ = Long.parseLong(fields[1]);
				boolean oneway = Boolean.parseBoolean(fields[2]);
				String highway = fields[3];
				String name = fields[4];
				float length = Float.parseFloat(fields[5]);
				int maxspeed = Integer.parseInt(fields[6].substring(0, fields[6].indexOf(' ')));
				
				// edge data
				StreetDetails meta = new StreetDetails(oneway, highway, name, length, maxspeed);
				int src = id2idx.getOrDefault(src_,-1);
				int dst = id2idx.getOrDefault(dst_,-1);
				// discard edge if it points to non existing node
				if(src<0 || dst<0){
					continue;
				}
				g.addEdge(src, dst, meta);
			}
			return g;
		}
	}
	
	public static StreetGraph loadBirminghamStreetGraph(){
		try {
			return loadStreetGraph(
					GraphLoader.class.getResource("/birmingham_node_list_cleaned.csv"), 
					GraphLoader.class.getResource("/birmingham_edge_list_cleaned.csv")
					);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the street graph, something is fishy.", e);
		}
	}
	
	public static WeightedGraph<String, String> loadExampleGraph(){
		WeightedGraph<String, String> g = new WeightedGraph<>();
		g.addNode("A");// 0
		g.addNode("B");// 1
		g.addNode("C");// 2
		g.addNode("D");// 3
		g.addNode("E");// 4
		g.addNode("F");// 5
		g.addNode("G");// 6
		g.addEdge(0, 1, 1.0).setMetaData("AB");
		g.addEdge(0, 3, 1.0).setMetaData("AD");
		g.addEdge(0, 5, 1.0).setMetaData("AF");
		g.addEdge(1, 4, 1.0).setMetaData("BE");
		g.addEdge(1, 6, 1.0).setMetaData("BG");
		g.addEdge(2, 0, 1.0).setMetaData("CA");
		g.addEdge(2, 1, 1.0).setMetaData("CB");
		g.addEdge(3, 6, 1.0).setMetaData("DG");
		g.addEdge(4, 2, 1.0).setMetaData("EC");
		g.addEdge(4, 6, 1.0).setMetaData("EG");
		g.addEdge(5, 1, 1.0).setMetaData("FB");
		g.addEdge(5, 3, 1.0).setMetaData("FD");
		return g;
	}

}
