package de.unistuttgart.vis.dsass2020.ex00.p3;

import de.unistuttgart.vis.dsass2020.ex00.p2.IVariableStorage;

public interface ITextStorage<T extends CharSequence> extends IVariableStorage<T> 
{
	/**
	 * Counts the number of equal characters in same positions of 
	 * the texts stored in this ITextStorage and the other storage. 
	 * <br>
	 * Example: 'abcdef' and 'abba' have two matching characters
	 * in the first two positions.
	 * @param other the other text storage
	 * @return the number of matching characters
	 */
	public int getNumberOfMatchingCharacters(ITextStorage<?> other);
}
