/**
 * <a href = "https://leetcode.com/problems/longest-increasing-path-in-a-matrix/">Problem here.</a>
 * <p></p>
 * Created by NubbY
 */
public class LongestIncreasingPathInAMatrix {

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int maxRows = 0;
    private int maxColumns = 0;

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix test = new LongestIncreasingPathInAMatrix();
        int[][] testArray =
                {{7, 0, 8},
                        {4, 7, 8},
                        {4, 7, 4}};
        System.out.println(test.longestIncreasingPath(testArray));
    }

    private boolean isInBound(int columnToCheck, int rowToCheck) {
        return ((columnToCheck >= 0 && rowToCheck >= 0) &&
                (columnToCheck <= maxColumns && rowToCheck <= maxRows));
    }

    private int longestPath(int[][] matrix, int[][] cache, int currentColumn, int currentRow, int currentValue) {
        if (cache[currentColumn][currentRow] != 0) {
            return cache[currentColumn][currentRow];
        }
        int maximumDistance = 1;
        for (int[] direction : directions) {
            int nextColumn = currentColumn + direction[0];
            int nextRow = currentRow + direction[1];

            if (!isInBound(nextColumn, nextRow)
                    || matrix[nextColumn][nextRow] <= currentValue) {
                continue;
            }

            int currentLength = 1 + longestPath(matrix, cache, nextColumn, nextRow, matrix[nextColumn][nextRow]);
            maximumDistance = Math.max(maximumDistance, currentLength);
        }
        cache[currentColumn][currentRow] = maximumDistance;
        return maximumDistance;
    }

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int longestIncreasingPath = 1;
        maxColumns = matrix.length - 1;
        maxRows = matrix[0].length - 1;
        int[][] cache = new int[maxColumns + 1][maxRows + 1];
        for (int column = 0; column <= maxColumns; column++) {
            for (int row = 0; row <= maxRows; row++) {
                int currentPath = longestPath(matrix, cache, column, row, matrix[column][row]);
                longestIncreasingPath = Math.max(longestIncreasingPath, currentPath);
            }
        }

        return longestIncreasingPath;
    }
}
