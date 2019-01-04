import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/unique-paths-ii/">Problem here.</a>
 */
public class UniquePaths2 {
    public static void main(String... args) {
        int[][] grid = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0}};

        UniquePaths2 test = new UniquePaths2();
        System.out.println(test.uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        else obstacleGrid[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];

        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];

        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        for (int[] line : obstacleGrid) System.out.println(Arrays.toString(line)); // for debug purposes only
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
