/**
 * <a href = "https://leetcode.com/problems/island-perimeter">Problem here </a>
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++) 
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                	int topCell = (i > 0) ? grid[i-1][j] : 0;
                	int bottomCell = (i == grid.length - 1) ? 0 : grid[i+1][j];
                	int leftCell = (j > 0) ? grid[i][j-1]: 0;
                	int rightCell = (j == grid[i].length - 1) ? 0 : grid[i][j+1];
                    perimeter += 4 - (topCell + bottomCell + leftCell + rightCell);
                 }
            }
        return perimeter;
    }

    //YandexTestFunny
    public static void main(String[] args) {
    	int[][] A  = {	{0,1,0,0},
    					{1,1,1,0},
    					{0,1,0,0},
    					{1,1,0,0}};
    	System.out.println(islandPerimeter(A));
    }
}
