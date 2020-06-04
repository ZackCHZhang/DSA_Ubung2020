package de.unistuttgart.vis.dsass2020.ex05.p1;

/**
 * This class represents an two-dimensional point
 */
public class Point {

  private static int counter = 0;

  public final int id;

  public final float x;
  public final float y;

  public Point(float x, float y) {
    this.x = x;
    this.y = y;
    this.id = counter++;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Point)) {
      return false;
    } else {
      return this.id == ((Point) object).id;
    }
  }

  @Override
  public String toString() {
    return Integer.toString(id);
  }
}
