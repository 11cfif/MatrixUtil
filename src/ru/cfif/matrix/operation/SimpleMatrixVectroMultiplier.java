package ru.cfif.matrix.operation;

import ru.cfif.matrix.Matrix;
import ru.cfif.matrix.Vector;

public class SimpleMatrixVectroMultiplier implements MatrixVectorMultiplier {
	@Override
	public Vector multiply(Matrix a, Vector x) {
		Vector result = new Vector(a.getColumns());
		for (int i = 0; i < a.getLines(); i++) {
			double sum = 0;
			for (int j = 0; j < x.size(); j++) {
				sum += a.get(i, j) * x.get(j);
			}
			result.put(i, sum);
		}
		return result;
	}
}
