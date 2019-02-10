import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/subsets/">Problem here.</a>
 * Created by NubbY
 */
public class Subsets {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5};
        List<List<Integer>> check = new Subsets().subsets(testArray);

        for (List<Integer> line : check) {
            for (int i = 0; i < line.size(); i++) {
                System.out.print(line.get(i) + ((i == line.size() - 1) ? "" : ", "));
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> newSubset = new ArrayList<>();
            out.add(newSubset);
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) == 0) {
                    newSubset.add(nums[j]);
                }
            }
        }
        return out;
    }
}
