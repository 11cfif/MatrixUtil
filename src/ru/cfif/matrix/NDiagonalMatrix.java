package ru.cfif.matrix;

public class NDiagonalMatrix extends Matrix {

	private final int nDiagonals;

	public NDiagonalMatrix(int n, int nDiagonals) {
		super(n, n);
		this.nDiagonals = nDiagonals;
	}

	@Override
	public void init() {
		a = new double[n][nDiagonals + 1];
	}

	@Override
	public int[] processIndex(int i, int j) {
		int halfDiagonals = nDiagonals >> 1;
		int y = halfDiagonals + j - i;
		if (y < 0 || y >= nDiagonals)
			y = nDiagonals;
		return new int[] {i, y};
	}

	public int getNDiagonals() {
		return nDiagonals;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for (int i = 0; i < a.length ; i++) {
			for (int j = 0; j < nDiagonals; j++) {
				if (j == 0)
					sb.append("[");
				sb.append(a[i][j]);
				if (j == nDiagonals - 1)
					sb.append("]");
				else
					sb.append(", ");
			}
			if (i != a.length - 1)
				sb.append(", \n");
		}
		sb.append("}");
		return sb.toString();
	}
}
