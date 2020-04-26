package de.unistuttgart.vis.dsass2020.ex00.p1;

public interface ICalculator {

	/** Returns a+b */
	public int add(int a, int b);
	/** Returns a*b */
	public int multiply(int a, int b);
	/** Returns minimum of a and b */
	public int minimum(int a, int b);
	/** Calculate Quersumme (for natural numbers including 0) */
	public int quersumme(int a);

}
