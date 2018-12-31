import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/pascals-triangle/">Problem here.</a>
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        int currentRow = 0;
        List<List<Integer>> out = new ArrayList<>();
        if (numRows == 0) return out;

        List<Integer> firstRow = new ArrayList<>();
        out.add(firstRow);
        firstRow.add(1);
        while (currentRow < numRows - 1) {
            List<Integer> outRow = new ArrayList<>();
            out.add(outRow);
            outRow.add(1);
            for (int i = 0; i < currentRow; i++) {
                outRow.add(out.get(currentRow).get(i) + out.get(currentRow).get(i + 1));
            }
            outRow.add(1);
            currentRow++;
        }
        return out;
    }

    public static void main(String... args) {
        PascalsTriangle test = new PascalsTriangle();
        List<List<Integer>> testList = test.generate(10);
        for(List<Integer> lst: testList) {
            for (Integer elem: lst) System.out.print(elem + ", ");
            System.out.print('\n');
        }
    }
}
