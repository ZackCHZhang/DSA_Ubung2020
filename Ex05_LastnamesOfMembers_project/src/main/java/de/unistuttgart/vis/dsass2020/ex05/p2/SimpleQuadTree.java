package de.unistuttgart.vis.dsass2020.ex05.p2;

import java.util.ArrayList;
import java.util.List;

import de.unistuttgart.vis.dsass2020.ex05.p1.Point;
import de.unistuttgart.vis.dsass2020.ex05.p1.Rectangle;
import de.unistuttgart.vis.dsass2020.ex05.p2.QuadTree;

public class SimpleQuadTree<T extends QuadTreeElement> extends QuadTree<T> {


	
  public SimpleQuadTree(final List<T> elements, final int maxElementsInLeaf)
      throws IllegalArgumentException {
    if (elements == null || maxElementsInLeaf < 1) {
      throw new IllegalArgumentException();
    } else {
      boundingBox = computeBoundingBox(elements);
      this.maxLeafElements = maxElementsInLeaf;
      createQuadTree(elements);
    }
  }

  public SimpleQuadTree(final List<T> elements, final int maxElementsInLeaf,
      final Rectangle boundingBox) throws IllegalArgumentException {
    this.boundingBox = boundingBox;
    this.maxLeafElements = maxElementsInLeaf;
    createQuadTree(elements);
  }

  private Rectangle computeBoundingBox(final List<T> elements) {
    // TODO Insert code for assignment 5.2.a
	  float minX=Float.MAX_VALUE;
	  float maxX=-Float.MAX_VALUE;
	  float minY=Float.MAX_VALUE;
	  float maxY=-Float.MAX_VALUE;
	  Point iterPoint;
	  for(T element : elements) {
		  iterPoint=element.getPosition();
		  if(iterPoint.x<minX) {
			  minX=iterPoint.x;
		  }else if(iterPoint.x>maxX) {
			  maxX=iterPoint.x;
		  }
		  if(iterPoint.y<minY) {
			  minY=iterPoint.y;
		  }else if(iterPoint.y>maxY) {
			  maxY=iterPoint.y;
		  }
	  }
	  return new Rectangle(minX,minY,maxX-minX,maxY-minY);
  }

  //还没考虑null的情况
  void createQuadTree(final List<T> list) throws IllegalArgumentException {
    // TODO Insert code for assignment 5.2.b
//	  Rectangle rootRect=this.computeBoundingBox(list);
//	  int maxElementsInLeaf=list.size();
//	  SimpleQuadTree<T> root =new SimpleQuadTree<T>(list,maxElementsInLeaf,rootRect);
	  
	  if(this.maxLeafElements>1) {
		  Rectangle rect0=this.subRectangle(boundingBox, 0);
		  Rectangle rect1=this.subRectangle(boundingBox, 1);		  
		  Rectangle rect2=this.subRectangle(boundingBox, 2);
		  Rectangle rect3=this.subRectangle(boundingBox, 3);
		  List<T> trList=new ArrayList();
		  List<T> tlList=new ArrayList();
		  List<T> brList=new ArrayList();
		  List<T> blList=new ArrayList();
		  for(T element : list) {
			  Point iter=element.getPosition();
//			  System.out.println(iter.x);
			  if(rect0.contains(iter)) {
				tlList.add(element);  
			  }else if(rect1.contains(iter)) {
				  blList.add(element);
			  }else if(rect2.contains(iter)) {
				  trList.add(element);
			  }else if(rect3.contains(iter)) {
				  brList.add(element);
			  }else {
				  throw new ArrayStoreException();
			  }
		  }
		  this.tl=new SimpleQuadTree<T>(tlList,tlList.size(),rect0);
		  this.tr=new SimpleQuadTree<T>(trList,trList.size(),rect2);
		  this.bl=new SimpleQuadTree<T>(blList,blList.size(),rect1);
		  this.br=new SimpleQuadTree<T>(brList,brList.size(),rect3);
	  }else {
		  this.leafElements=list;
	  }
  }
  
//  ________________________________________
//  |                 |                      |
//  |      0 tl       |         2 tr         |
//  |———————————————————————————————————————-|
//  |       1 bl      |          3 br        |
//  |_________________|______________________|
//  
  Rectangle subRectangle (Rectangle rect,int num) {
	  if(num==0) {
		  return new Rectangle(rect.x,rect.y,rect.width/2,rect.height/2);
	  }else if(num==1) {
		  return new Rectangle(rect.x,rect.y+rect.width/2,rect.width/2,rect.height/2);
	  }else if(num==2) {
		  return new Rectangle(rect.x+rect.width/2,rect.y,rect.width/2,rect.height/2);
	  }else if(num==3) {
		  return new Rectangle(rect.x+rect.width/2,rect.y+rect.height/2,rect.width/2,rect.width/2);
	  }else {
		  throw new IllegalArgumentException();
	  }
  }

  
  
  @Override
  public void rangeQuery(final List<T> resultList, final Rectangle query) {
    // TODO Insert code for assignment 5.2.c
	  List<T> list=new ArrayList();
	  rekRangeQuery(this,list);
	  for(T iter : list) {
		  
		  Point iterPoint=iter.getPosition();
		  if(query.contains(iterPoint)) {
			  resultList.add(iter);
		  }
	  }
  }
  private void rekRangeQuery(QuadTree qt,List<T> list) {
	  if(qt.leafElements!=null) {
		  list.addAll(qt.leafElements) ;
	  }else {
		  rekRangeQuery(qt.bl,list);
		  rekRangeQuery(qt.br,list);
		  rekRangeQuery(qt.tl,list);
		  rekRangeQuery(qt.tr,list);
	  }
  }

}
