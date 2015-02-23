package ru.cfif.matrix.solvers;

import ru.cfif.matrix.Matrix;
import ru.cfif.matrix.Vector;

public interface SystemSolver {
	public Vector solve(Matrix a, Vector b);
}
