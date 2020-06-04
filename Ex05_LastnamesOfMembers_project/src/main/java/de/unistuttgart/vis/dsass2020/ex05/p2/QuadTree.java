package de.unistuttgart.vis.dsass2020.ex05.p2;

import java.util.List;

import de.unistuttgart.vis.dsass2020.ex05.p1.Rectangle;

public abstract class QuadTree<T extends QuadTreeElement> {

  /**
   * top right sub-node of the quad tree
   */
  QuadTree<T> tr = null;

  /**
   * top left sub-node of the quad tree
   */
  QuadTree<T> tl = null;

  /**
   * bottom left sub-node of the quad tree
   */
  QuadTree<T> bl = null;

  /**
   * bottom right sub-node of the quad tree
   */
  QuadTree<T> br = null;

  /**
   * If non-null this node is a leaf node and this member contains the elements
   */
  List<T> leafElements = null;

  /**
   * Holds the area of this node
   */
  Rectangle boundingBox;

  /**
   * The maximum number of elements in a leaf node
   */
  int maxLeafElements;

  /**
   * Performs a two-dimensional range query and adds all elements in the
   * selected area to the result list.
   * 
   * This method does not clear the given list before add new elements.
   * 
   * @param resultList: List that is used to store the elements that are
   *        contained in the selected area
   * @param selecedArea: the result list contains all element that are within
   *        the selected area
   */
  public abstract void rangeQuery(final List<T> resultList,
      final Rectangle query);

  /**
   * This method recursively creates the quad tree.
   * 
   * @param list of elements to be stored in the quad tree
   * @throws QuadTreeException
   */
  abstract void createQuadTree(final List<T> list)
      throws IllegalArgumentException;

  /**
   * Return the rectangle that encloses the point set of this node.
   * 
   * @return the bounding box
   */
  Rectangle getBoundingBox() {
    return this.boundingBox;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof QuadTree)) {
      return false;
    } else {
      if (leafElements != null) {
        return leafElements.equals(((QuadTree<?>) object).leafElements);
      } else {
        return tr.equals(((QuadTree<?>) object).tr)
            && tl.equals(((QuadTree<?>) object).tl)
            && bl.equals(((QuadTree<?>) object).bl)
            && br.equals(((QuadTree<?>) object).br);
      }
    }
  }
}
