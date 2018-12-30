import java.util.Arrays;

public class RotateImage {

    public static void main(String... args) {
        RotateImage test = new RotateImage();
        int[][] testMatrix =
                {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};

        test.rotate(testMatrix);
        for (int[] out : testMatrix) System.out.println(Arrays.toString(out));

    }

    public void rotate(int[][] matrix) {

        int edge = matrix.length - 1;
        int offset = 0;
        int n = matrix.length;

        while (edge >= 1) {
            for (int i = 0; i < edge; i++) {

                int tmp = matrix[offset][i + offset];
                matrix[offset][i + offset] = matrix[n - i - offset - 1][offset];
                matrix[n - i - offset - 1][offset] = matrix[n - offset - 1][n - i - offset - 1];
                matrix[n - offset - 1][n - i - offset - 1] = matrix[i + offset][n - offset - 1];
                matrix[i + offset][n - offset - 1] = tmp;
            }

            edge -= 2;
            offset++;

        }
    }
}
