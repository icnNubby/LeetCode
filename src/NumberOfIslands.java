/**
 * <a href = "https://leetcode.com/problems/number-of-islands/">Problem here.</a>
 * <p></p>
 * Created by NubbY
 */
public class NumberOfIslands {

    public void dfs(char[][] grid, int row, int col, char mark) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length) return;

        if (grid[row][col] == mark || grid[row][col] == '0') return;

        grid[row][col] = mark;
        dfs(grid, row - 1, col, mark);
        dfs(grid, row, col + 1, mark);
        dfs(grid, row, col - 1, mark);
        dfs(grid, row + 1, col, mark);
    }

    public int numIslands(char[][] grid) {
        char mark = 2;
        int markCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, mark);
                    while (mark == '0' || mark == '1') {
                        mark++;
                    }
                    markCount++;
                }
            }
        }
        return markCount;
    }
}
