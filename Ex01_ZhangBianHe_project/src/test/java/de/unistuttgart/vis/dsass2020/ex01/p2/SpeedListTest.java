package de.unistuttgart.vis.dsass2020.ex01.p2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

//import de.unistuttgart.vis.dsass2020.ex01.p2.SpeedList;

public class SpeedListTest {
	private SpeedList<Integer> list1 = new SpeedList();
	private SpeedList<Integer> list2 = new SpeedList();

	public void ListPreInit(int lang) throws Exception {
		for (int i = lang-1; i >= 0; i--) {
			list1.prepend(i);
			
		}
	}

	public void ListApInit(int lang) throws Exception {
		for (int i = 0; i < lang; i++) {
			list2.append(i);
			
		}
	}

	@Test
	public void testPreList() throws Exception {
		int lang = 20;
		this.ListPreInit(lang);
		for (int i = 0; i <lang; i++) {
			System.out.println(list1.getElementAt(i));
			assertEquals((int) i, (int) list1.getElementAt(i));
			
		}

	}
	
	@Test
	public void testApList() throws Exception{
		int lang =11;
		this.ListApInit(lang);
		for(int i=0;i<lang;i++) {
			assertEquals(i,(int) list2.getElementAt(i));
			assertEquals(lang,(int)list2.size());
		}
	}
	
}
