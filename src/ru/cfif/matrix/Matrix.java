package ru.cfif.matrix;

import ru.cfif.matrix.operation.MatrixMatrixMultiplier;
import ru.cfif.matrix.operation.MatrixVectorMultiplier;

public abstract class Matrix {

	public static Matrix getIdentityMatrix(int n) {
		return new IdentityMatrix(n);
	}

	protected final int n;
	protected final int m;

	protected double[][] a;

	public Matrix(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public abstract void init();

	public void add(Matrix b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				a[i][j] += b.universalGet(i, j);
		}
	}

	public double get(int i, int j) {
		return a[i][j];
	}

	public void put(int i, int j, double value) {
		a[i][j] = value;
	}

	public double universalGet(int i, int j) {
		int[] indexes = processIndex(i, j);
		return a[indexes[0]][indexes[1]];
	}

	public void universalPut(int i, int j, double value) {
		int[] indexes = processIndex(i, j);
		a[indexes[0]][indexes[1]] = value;
	}

	public abstract int[] processIndex(int i, int j);

	public int getColumns() {
		return m;
	}

	public int getLines() {
		return n;
	}

	public Vector multiplyByVector(MatrixVectorMultiplier multiplier, Vector x) {
		return multiplier.multiply(this, x);
	}

	public Matrix multiplyByMatrix(MatrixMatrixMultiplier multiplier, Matrix b) {
		return multiplier.multiply(this, b);
	}

	//------------------------- IDENTITY MATRIX -------------------------

	public static class IdentityMatrix extends Matrix {

		public IdentityMatrix(int n) {
			super(n, n);
		}

		@Override
		public void init() {
			a = new double[1][2];
			a[0][0] = 1;
			a[0][1] = 0;
		}

		@Override
		public void put(int i, int j, double value) {
			throw new IllegalStateException("This is identity matrix");
		}

		@Override
		public int[] processIndex(int i, int j) {
			if (i != j)
				return new int[]{0, 1};
			return new int[]{0, 0};
		}

		@Override
		public int hashCode() {
			return n * 17;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof IdentityMatrix && n == ((IdentityMatrix)obj).n;
		}

		@Override
		public String toString() {
			return "I_n";
		}
	}
}
