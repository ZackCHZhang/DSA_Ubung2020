package de.unistuttgart.vis.dsass2020.ex00.p1;

public class Calculator implements ICalculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int minimum(int a, int b) {
		return a > b ? b : a;
	}

	public int quersumme(int a) {
		int result = 0;
		while (a != 0) {
			result += a % 10;
			a = a / 10;
		}
		return result;
	}
}