package ru.cfif.matrix.operation;

import ru.cfif.matrix.Matrix;
import ru.cfif.matrix.Vector;

public interface MatrixVectorMultiplier {
	public Vector multiply(Matrix a, Vector x);
}
