package de.unistuttgart.vis.dsass2020.ex00.p2;

public interface IVariableStorage<T> {

	/** Sets the variable */
	public void set(T var);
	/** Returns the variable */
	public T get();

}
