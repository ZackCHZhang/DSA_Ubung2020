package de.unistuttgart.vis.dsass2020.ex05.p2;

import de.unistuttgart.vis.dsass2020.ex05.p1.Point;

public class IQuadTreeElement implements QuadTreeElement {

	private Point location;
	
	public IQuadTreeElement() {
		this.location=new Point(0.0f,0.0f);
	}
	public IQuadTreeElement(Point point) {
		this.location=point;
	}
	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return this.location;
	}

}
