import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/combinations/">Problem here.</a>
 * Created by NubbY
 */
public class Combinations {
    private List<List<Integer>> combos = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> testOut = new Combinations().combine(6, 3);
        for (List<Integer> list : testOut) {
            for (int element : list) {
                System.out.print(element + ", ");
            }
            System.out.println();
        }
    }

    private void getCombos(int[] prefix, int currentPos, int n, int k) {
        if (prefix.length == k) {
            List<Integer> newList = new ArrayList<>();
            for (int elem : prefix) newList.add(elem);
            combos.add(newList);
            return;
        }
        if (currentPos > n) return;
        int[] newPrefix = new int[prefix.length + 1];
        System.arraycopy(prefix, 0, newPrefix, 0, prefix.length);
        newPrefix[newPrefix.length - 1] = currentPos;
        getCombos(newPrefix, currentPos + 1, n, k);
        getCombos(prefix, currentPos + 1, n, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        getCombos(new int[]{}, 1, n, k);
        return combos;
    }
}
