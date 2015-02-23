package ru.cfif.matrix;

import ru.cfif.matrix.solvers.SystemSolver;
import ru.cfif.matrix.solvers.TDMASolver;

public class Test {
	public static void main(String[] args) {
		testOwn();
		System.out.println("----------------------");
		testTwo();

	}

	private static void testTwo() {
		Matrix m = new NDiagonalMatrix(4, 3);
		m.init();
		m.put(0,1,1);
		m.put(1,1,1);
		m.put(2,1,1);
		m.put(3,1,1);

		Vector f = new Vector(4);
		f.put(0, 1);
		f.put(1, 1);
		f.put(2, 1);
		f.put(3, 1);

		SystemSolver solver = new TDMASolver();

		System.out.println(solver.solve(m, f));
		System.out.println(m);
	}

	private static void testOwn() {
		Matrix m = new NDiagonalMatrix(4, 3);
		m.init();
		m.put(0,1,3d);
		m.put(0,2,4d);

		m.put(1,0,5d);
		m.put(1,1,6d);
		m.put(1,2,7d);

		m.put(2,0,9d);
		m.put(2,1,1d);
		m.put(2,2,2d);

		m.put(3,0,1d);
		m.put(3,1,2d);

		Vector f = new Vector(4);
		f.put(0, 7d);
		f.put(1, 18d);
		f.put(2, 12d);
		f.put(3, 3d);

		SystemSolver solver = new TDMASolver();

		System.out.println(solver.solve(m, f));
		System.out.println(m);
	}

}
