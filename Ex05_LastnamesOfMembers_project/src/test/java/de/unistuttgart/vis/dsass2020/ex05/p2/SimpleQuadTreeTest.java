package de.unistuttgart.vis.dsass2020.ex05.p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.unistuttgart.vis.dsass2020.ex05.p1.Point;
import de.unistuttgart.vis.dsass2020.ex05.p1.Rectangle;

public class SimpleQuadTreeTest {

//	|_______________________________________________
//	1|                   |                           |
//	2|      o            |          o                |
//	3|                   |                           |
//  4|                   |                           |	
//	5|                   |                           |
//	6|                   |                           |
//	7|                   |                           |
//	8|________________________________________________ 
//	9|                   |            |               |
// 10|                   |   o        |               |
// 11|                   |            |               |
// 12|                   |____________|_______________|
// 13|       o           |            |               |
//14 |                   |            |               |
//15 |                   |    o       |     o         |
//16 |                   |            |               |
//   _________________________________|_______________
	@Test
	public void TestCreatTree() {
		Rectangle rect=new Rectangle(0,0,16,16);
		List<QuadTreeElement> testList=new ArrayList();
		testList.add(new IQuadTreeElement(new Point(2.5f,2.5f)));
		testList.add(new IQuadTreeElement(new Point(11.5f,2f)));
		testList.add(new IQuadTreeElement(new Point(9.5f,9.5f)));
		testList.add(new IQuadTreeElement(new Point(9.5f,15.5f)));
		testList.add(new IQuadTreeElement(new Point(2.5f,14f)));
		testList.add(new IQuadTreeElement(new Point(15.5f,15.5f)));

		SimpleQuadTree testTree=new SimpleQuadTree(testList,testList.size(),rect);
		List<QuadTreeElement> resultList=new ArrayList();
		Rectangle testRectangle=new Rectangle(0,0,8,8);
		testTree.rangeQuery(resultList, testRectangle);
		for(QuadTreeElement iter:resultList) {
			Point iterPoint=iter.getPosition();
			System.out.println("______________________");
			System.out.println(iterPoint.x);
			System.out.println(iterPoint.y);
			System.out.println("______________________");
		}
		assertEquals((int)2.5, (int)resultList.get(0).getPosition().x);
	}
	
}
