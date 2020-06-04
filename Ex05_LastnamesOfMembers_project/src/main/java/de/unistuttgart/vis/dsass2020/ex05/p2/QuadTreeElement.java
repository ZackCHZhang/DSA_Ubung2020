package de.unistuttgart.vis.dsass2020.ex05.p2;

import de.unistuttgart.vis.dsass2020.ex05.p1.Point;

public interface QuadTreeElement {

  /**
   * Returns the position of a quad tree element.
   * 
   * @return anchor point
   */
  public abstract Point getPosition();
}
