import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/surrounded-regions">Problem here.</a>
 */
public class SurroundedRegions {

    private char[][] board;

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
        char[][] testArray = {
                {'X', 'X', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'O'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'O', 'X'}};
        test.solve(testArray);
        for (char[] line : testArray)
            System.out.println(Arrays.toString(line));
    }

    private void findAllImpossibilities(int x, int y) {

        if (board[x][y] == 'X' || board[x][y] == 'N') return;

        board[x][y] = 'N';

        if (x + 1 < board.length - 1) findAllImpossibilities(x + 1, y);
        if (x - 1 >= 0) findAllImpossibilities(x - 1, y);
        if (y + 1 < board[0].length - 1) findAllImpossibilities(x, y + 1);
        if (y - 1 >= 0) findAllImpossibilities(x, y - 1);

    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            findAllImpossibilities(i, 0);
            findAllImpossibilities(i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            findAllImpossibilities(0, i);
            findAllImpossibilities(board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'N')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

}
