package ru.cfif.matrix;

import java.util.Arrays;

public class Vector {

	private final int n;
	private double v[];

	public Vector(int n) {
		this.n = n;
		v = new double[n];
	}

	public double get(int i) {
		return v[i];
	}

	public void put(int i, double value) {
		v[i] = value;
	}

	public int size() {
		return n;
	}

	public Vector add(Vector u) {
		for (int i = 0; i < n; i++)
			v[i] += u.get(i);
		return this;
	}

	public Vector multByNumber(double number) {
		for (int i = 0; i < n; i++)
			v[i] *= number;
		return this;
	}

	public double scalarMult(Vector u) {
		double sum = 0;
		for (int i = 0; i < n; i++)
			sum += v[i] * u.get(i);
		return sum;
	}

	@Override
	public String toString() {
		return Arrays.toString(v);
	}

}
