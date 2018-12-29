import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/spiral-matrix-ii/"> Problem here.</a>
 */
public class SpiralMatrix2 {
    public static void main(String... args) {
        SpiralMatrix2 test = new SpiralMatrix2();
        int[][] testMatrix = test.generateMatrix(2);
        for (int[] line : testMatrix)
            System.out.println(Arrays.toString(line));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int currentEdge = n;
        int currentNumber = 1;
        int xPos = 0;
        int yPos = 0;
        while (currentEdge > 0) {

            matrix[yPos][xPos] = currentNumber;
            for (int i = xPos; i < xPos + currentEdge; i++) {
                matrix[yPos][i] = currentNumber;
                currentNumber++;
            }
            xPos += currentEdge - 1;
            yPos++;

            for (int i = yPos; i < yPos + currentEdge - 1; i++) {
                matrix[i][xPos] = currentNumber;
                currentNumber++;
            }
            yPos += (currentEdge - 2);
            xPos--;

            for (int i = xPos; i > xPos - currentEdge + 1; i--) {
                matrix[yPos][i] = currentNumber;
                currentNumber++;
            }
            xPos -= (currentEdge - 2);
            yPos--;

            for (int i = yPos; i > yPos - currentEdge + 2; i--) {
                matrix[i][xPos] = currentNumber;
                currentNumber++;
            }
            yPos -= (currentEdge - 2);

            currentEdge -= 2;
            xPos++;
            yPos++;
        }
        return matrix;
    }
}
