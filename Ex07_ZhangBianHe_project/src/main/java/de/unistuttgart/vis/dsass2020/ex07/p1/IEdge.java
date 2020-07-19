package de.unistuttgart.vis.dsass2020.ex07.p1;

public interface IEdge<E> {

  /**
   * Returns the tail (source) vertex of the directed edge.
   * 
   * @return the tail (source) vertex of the edge
   */
  public int getSource();

  /**
   * Returns the head (destination) vertex of the directed edge.
   * 
   * @return the head (destination) vertex of the directed edge
   */
  public int getDestination();

  /**
   * Returns the weight of the directed edge.
   * 
   * @return the weight of the directed edge
   */
  public double getWeight();
  
  /**
   * @return meta data of this edge
   */
  public E getMetaData();

}
