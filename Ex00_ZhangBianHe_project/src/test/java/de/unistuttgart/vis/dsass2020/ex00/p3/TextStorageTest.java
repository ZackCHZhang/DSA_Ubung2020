package de.unistuttgart.vis.dsass2020.ex00.p3;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * You should use this class to test your class {@link TextStorage}, using
 * JUnit assertions like {@link Assert#assertEquals(Object, Object)}. For
 * additional information on how to test your code with JUnit visit 
 * http://www.vogella.com/tutorials/JUnit/article.html
 */
public class TextStorageTest {
	@Test
	public void testTextStorge() {
		final CharSequence myStorge="cbcdefffc";
		final CharSequence otherStoge="abbaadffdd";
		final ITextStorage<CharSequence> myText= new TextStorage<CharSequence>();
		final ITextStorage<CharSequence> otherText= new TextStorage<CharSequence>();
		myText.set(myStorge);
		otherText.set(otherStoge);
		
		assertEquals(3,myText.getNumberOfMatchingCharacters(otherText));
	
	}
}
