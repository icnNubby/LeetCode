import java.util.*;

/**
 * <a href = "https://leetcode.com/problems/permutations/">Problem here.</a>
 * <a href = "https://leetcode.com/problems/permutations-ii/">Problem #2.</a>
 */
public class Permutations {

    //Two problems, second actually contains first, but solution for the first one will be alot faster if we use
    //appropriate structures (ArrayList for ex.)

    private Set<List<Integer>> permuts = new HashSet<List<Integer>>();
    private int size;
    private int[] numbers;

    public static void main(String[] args) {
        Permutations test = new Permutations();
        int[] testArray = {1, 1, 2};
        List<List<Integer>> print = test.permute(testArray);
        for (List<Integer> line : print) {
            System.out.println(Arrays.toString(line.toArray()));
        }
    }

    private void makeAllPermuts(boolean[] tags, Integer[] currentList, int pos) {
        if (pos == size) {
            permuts.add(Arrays.asList(currentList));
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!tags[i]) {
                tags[i] = true;
                Integer[] copy = new Integer[currentList.length + 1];
                System.arraycopy(currentList, 0, copy, 0, currentList.length);
                copy[pos] = numbers[i];
                makeAllPermuts(tags, copy, pos + 1);
                tags[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        size = nums.length;
        numbers = nums;
        boolean[] tags = new boolean[size];
        makeAllPermuts(tags, new Integer[0], 0);
        List<List<Integer>> out = new ArrayList<>();
        for (List<Integer> lines : permuts) {
            out.add(lines);
        }
        return out;
    }
}
