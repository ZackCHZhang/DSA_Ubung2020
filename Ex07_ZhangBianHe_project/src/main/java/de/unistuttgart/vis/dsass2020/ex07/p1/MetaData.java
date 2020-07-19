package de.unistuttgart.vis.dsass2020.ex07.p1;

public class MetaData {
	
	public static final int NODE_GURLEY_CIRCLE = 2744;
	public static final int NODE_AIRPORT = 11683;
	public static final int NODE_ALABAMA_THEATRE = 3373;
	public static final int NODE_UNIVERSITY = 11913;
	public static final int NODE_HEALTH_CENTER = 5829;
	
	/**
	 * Details of a junction consisting of x,y coordinates,
	 * its open street map ID and supplementary information about the junction
	 * such as stop signs or traffic signals.
	 */
	public static class JunctionDetails {
		/** open street map id of node */
		public final long osmid;
		/** longitude */ 
		public final float x;
		/** latitude */
		public final float y;
		/** extra information about junction if available, e.g. traffic signals or stop sign */
		public final String extra;
		
		public JunctionDetails(long osmid, float x, float y, String highway) {
			this.osmid = osmid;
			this.x = x;
			this.y = y;
			this.extra = highway;
		}
		
		@Override
		public String toString() {
			return String.format("{id=%d, x=%f, y=%f, hw=%s}", osmid,x,y,extra);
		}
	}
	
	/**
	 * Details of a street segment consisting of information about being a one way street, 
	 * the type of street/highway, the street's name, its length, and speed limit (mph).
	 */
	public static class StreetDetails {
		/** true when street segment is of one way street */
		public final boolean oneway;
		/** type of the street: residential,primary,secondary,tertiary,motorway,trunk,road,unclassified,... */
		public final String highway;
		/** name of the street */
		public final String name;
		/** street segment length in meters */
		public final float length;
		/** speed limit in miles/hour */
		public final int maxspeed;
		
		public StreetDetails(boolean oneway, String highway, String name, float length, int maxspeed) {
			this.oneway = oneway;
			this.highway = highway;
			this.name = name;
			this.length = length;
			this.maxspeed = maxspeed;
		}
		
		@Override
		public String toString() {
			return String.format("{name=%s, oneway=%s, hw=%s, len=%f, spd=%d}", name,""+oneway,highway,length,maxspeed);
		}
	}
	
}
