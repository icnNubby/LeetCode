import java.util.HashSet;

/**
 * <a href = "https://leetcode.com/problems/valid-sudoku/">Problem here.</a>
 * Created by NubbY
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] testArray = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        ValidSudoku test = new ValidSudoku();

        System.out.println(test.isValidSudoku(testArray));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cell = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !column.add(board[j][i]))
                    return false;
                int rowIndex = 3 * (i / 3);
                int columnIndex = 3 * (i % 3);

                if (board[rowIndex + (j / 3)][columnIndex + (j % 3)] != '.' &&
                        !cell.add(board[rowIndex + j / 3][columnIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }
}
