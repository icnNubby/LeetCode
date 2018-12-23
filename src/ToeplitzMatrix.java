/**
 * <a href = "https://leetcode.com/problems/toeplitz-matrix/"> Problem here. </a>
 * @author icnNubby
 *
 */
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix.length < 2) return true;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (matrix[i - 1][j] != matrix[i][j + 1]) return false;
			}
		}
		return true;
	}
}
