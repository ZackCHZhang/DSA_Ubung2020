package de.unistuttgart.vis.dsass2020.ex05.p1;

import java.util.Collection;

/**
 * This class represents a quadrilateral, where the angles are 90 degrees.
 */
public class Rectangle {

  // Upper left corner of the rectangle
  public final float x;
  public final float y;

  public final float width;
  public final float height;

  /**
   * Generate a new rectangle
   * 
   * @param x      left position of the rectangle
   * @param y      upper position of the rectangle
   * @param width
   * @param heigth
   */
  public Rectangle(float x, float y, float width, float height) {
	// enforce positive width
	if (width >= 0) {
    	this.x = x;
    	this.width = width;
	} else {
    	this.x = x + width;
    	this.width = -width;
	}
	// enforce positive height
    if (height >= 0) {
    	this.y = y;
    	this.height = height;
    } else {
    	this.y = y + height;
    	this.height = -height;
    }
  }

  /**
   * @param point
   * @return true iff the point is inside the rectangle
   */
  public boolean contains(final Point point) {
    // TODO Insert code for assignment 5.1.a;
	  if (point.x>this.x && point.x<this.x+this.width&&point.y<this.y+this.height && point.y>this.y) {

			  return true;
		  
	  }
	  return false;
  }

  /**
   * @param rectangle
   * @return true iff the rectangle intersects this rectangle
   */
  public boolean intersects(final Rectangle rectangle) {
    // TODO Insert code for assignment 5.1.b
	  if(rectangle.x<this.x && rectangle.x+rectangle.width>this.x && rectangle.y>this.y && rectangle.y<this.y+this.height) {
		  return true;
	  }else if(rectangle.x<this.x+this.width && rectangle.x+rectangle.width>this.x+this.width && rectangle.y>this.y && rectangle.y<this.y+this.height) {
		  return true;
	  }else if(rectangle.x<this.x && rectangle.x+rectangle.width>this.x && rectangle.y<this.y && rectangle.y+rectangle.height>this.y) {
		  return true;
	  }else if(rectangle.x<this.x && rectangle.x+rectangle.width>this.x && rectangle.y<this.y+this.height && rectangle.y+rectangle.height>this.y+this.height) {
		  return true;
	  }else {
		  return false;
	  }
  }

  /**
   * Compute the bounding rectangle for a set of rectangles.
   * 
   * @param rectangles
   * @return the bounding rectangle
   */
  public static Rectangle getBoundingBox(final Collection<Rectangle> rectangles) {
    float minX = Float.MAX_VALUE;
    float maxX = -Float.MAX_VALUE;
    float minY = Float.MAX_VALUE;
    float maxY = -Float.MAX_VALUE;
    for (Rectangle rectangle : rectangles) {
      if (rectangle.x < minX) {
        minX = rectangle.x;
      }
      if (rectangle.x + rectangle.width > maxX) {
        maxX = rectangle.x + rectangle.width;
      }
      if (rectangle.y < minY) {
        minY = rectangle.y;
      }
      if (rectangle.y + rectangle.height > maxY) {
        maxY = rectangle.y + rectangle.height;
      }
    }
    return new Rectangle(minX, minY, maxX - minX, maxY - minY);
  }

  /**
   * Extends the rectangle to cover a set of points.
   * 
   * @param points
   * @return the grown rectangle that includes all {@link points}.
   */
  public Rectangle extendTo(final Collection<Point> points) {
    // TODO Insert code for assignment 5.1.c
	  float minX=this.x;
	  float minW=this.width;
	  float minY=this.y;
	  float minH=this.height;
	  for(Point point : points) {
		  if(point.x<minX) {
			  minX=point.x;
		  }else if(point.x-minX>minW) {
			  minW=point.x-minX;
		  }
		  if(point.y<minY) {
			  minY=point.y;
		  }else if(point.y-minY>minH) {
			  minH=point.y-minY;
		  }
	  }
	  return new Rectangle(minX,minY,minW,minH);
  }
  
}
