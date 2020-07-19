package de.unistuttgart.vis.dsass2020.ex05.p3;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import de.unistuttgart.vis.dsass2020.ex05.p1.Rectangle;

public class CollisionMapTest {
@Test
public void test() throws CollisionMapOutOfBoundsException{
	Set<Rectangle> testList=new HashSet<Rectangle>();
	testList.add(new Rectangle(0,0,4,4));
	testList.add(new Rectangle(3,0,3,4));
	testList.add(new Rectangle(7,0,8,7));
	testList.add(new Rectangle(1,2,6,5));
	testList.add(new Rectangle(3,4,4,4));
	CollisionMap map=new CollisionMap(testList);
	System.out.println(map.collide(new Rectangle(15,15,3,3)));
	Set<Rectangle> resultList=new HashSet<Rectangle>();
	resultList=map.getCollisionCandidates(new Rectangle(0,0,5,5));
	for(Rectangle rect : resultList) {
		System.out.println("___________________");
		System.out.println(rect.x);
		System.out.println(rect.y);
		System.out.println("___________________");
	}
}
}
