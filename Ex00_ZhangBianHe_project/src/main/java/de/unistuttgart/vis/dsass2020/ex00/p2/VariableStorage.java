package de.unistuttgart.vis.dsass2020.ex00.p2;



public class VariableStorage<T> implements IVariableStorage<T> {
	private T myStorge=null;
	
	public void set(T var) {
		this.myStorge=var;
	}

	public T get() {
		return myStorge;
	}

}
