/**
 * <a href = "https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/">Problem here.</a>
 * <p></p>
 * O ( n * n * m ) time efficiency
 * Created by NubbY
 */
public class FlipColumnsForMaximumNumberOfEqualRows {

    public static void main(String[] args) {
        int[][] testArr = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        FlipColumnsForMaximumNumberOfEqualRows test = new FlipColumnsForMaximumNumberOfEqualRows();
        System.out.println(test.maxEqualRowsAfterFlips(testArr));
    }

    private boolean compareRows(int[] row1, int[] row2) {
        if (row1.length != row2.length) {
            return false;
        }

        boolean compareDirectly = true;
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] != row2[i]) {
                compareDirectly = false;
                break;
            }
        }

        boolean compareFlipped = true;
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] != 1 - row2[i]) {
                compareFlipped = false;
                break;
            }
        }

        return compareDirectly || compareFlipped;
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maximumEqualsRows = 0;
        for (int[] baseRow : matrix) {
            int sameRows = 0;
            for (int[] compareRow : matrix) {
                if (compareRows(baseRow, compareRow)) {
                    sameRows++;
                }
            }
            maximumEqualsRows = Math.max(maximumEqualsRows, sameRows);
        }
        return maximumEqualsRows;
    }
}
