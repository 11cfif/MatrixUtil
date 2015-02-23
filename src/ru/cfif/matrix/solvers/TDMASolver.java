package ru.cfif.matrix.solvers;

import ru.cfif.matrix.*;

public class TDMASolver implements SystemSolver {

	NDiagonalMatrix matrix;
	Vector vector;
	int n;

	double[] alpha;
	double[] betta;

	@Override
	public Vector solve(Matrix a, Vector f) {
		matrix = (NDiagonalMatrix)a;
		vector = f;
		n = f.size();
		alpha = new double[n];
		betta = new double[n];
		calcCoef();
		return calcResult();
	}

	private void calcCoef() {
		double denominator = matrix.get(0, 1);
		alpha[0] = -matrix.get(0, 2) / denominator;
		betta[0] = vector.get(0) / denominator;
		for (int i = 1; i < n; i++) {
			denominator = -matrix.get(i, 1) - matrix.get(i, 0) * alpha[i - 1];
			alpha[i] = matrix.get(i, 2) / denominator;
			betta[i] = (matrix.get(i, 0) * betta[i - 1] - vector.get(i)) / denominator;
		}
	}

	private Vector calcResult() {
		Vector result = new Vector(n);
		double value = betta[n - 1];
		result.put(n - 1, value);
		for (int i = n - 2; i >= 0; i--) {
			value = alpha[i] * value + betta[i];
			result.put(i, value);
		}
		return result;
	}
}
