
public abstract class DB {
	int[][] matrix = new int[3][3];

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	abstract void printMatrix();

}
