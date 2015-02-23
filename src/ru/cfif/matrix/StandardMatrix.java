package ru.cfif.matrix;

public class StandardMatrix extends Matrix {

	public StandardMatrix(int n, int m) {
		super(n, m);
	}

	@Override
	public void init() {
		a = new double[n][m];
	}

	@Override
	public int[] processIndex(int i, int j) {
		return new int[] {i, j};
	}
}
