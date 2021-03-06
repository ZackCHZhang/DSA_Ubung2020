package de.unistuttgart.vis.dsass2020.ex00.p3;

import de.unistuttgart.vis.dsass2020.ex00.p2.VariableStorage;

public class TextStorage<T extends CharSequence> extends VariableStorage<T> implements ITextStorage<T> {
	public int getNumberOfMatchingCharacters(ITextStorage<?> other) {
		int result = 0;
		CharSequence myString = this.get();
		CharSequence otherString = other.get();
		int len=myString.length()>otherString.length()?otherString.length():myString.length();
		for (int i = 0;i<len; i++) {
			if (myString.charAt(i) == otherString.charAt(i)) {
				result++;
			} 
		}
		return result;
	}

}
