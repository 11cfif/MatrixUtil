package ru.cfif.matrix.operation;

import ru.cfif.matrix.Matrix;
import ru.cfif.matrix.StandardMatrix;

public class SimpleMatrixMatrixMultiplier implements MatrixMatrixMultiplier {
	@Override
	public Matrix multiply(Matrix a, Matrix b) {
		Matrix result = new StandardMatrix(a.getLines(), b.getColumns());
		for (int i = 0; i < a.getLines(); i++) {
			for (int j = 0; j < b.getColumns(); j++) {
				double sum = 0;
				for (int k = 0; k < a.getColumns(); k++)
					sum += a.get(i, k) * b.get(j, k);
				result.put(i, j, sum);
			}
		}
		return result;
	}
}
