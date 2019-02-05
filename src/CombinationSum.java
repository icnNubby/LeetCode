import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/combination-sum/">Problem here.</a>
 * Created by NubbY
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] testArray = {48, 22, 49, 24, 26, 47, 33, 40, 37, 39, 31, 46, 36, 43, 45, 34, 28, 20, 29, 25, 41, 32, 23};
        int testTarget = 69;
        CombinationSum test = new CombinationSum();
        List<List<Integer>> out = test.combinationSum(testArray, testTarget);
        for (List<Integer> pos : out) {
            System.out.println(Arrays.toString(pos.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        for (int t = 0; t <= target; t++) {
            dp[t] = new ArrayList<>();
            List<List<Integer>> combList = new ArrayList<>();

            for (int j = 0; j < candidates.length && candidates[j] <= t; j++) {
                if (candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j]));
                } else {
                    for (List<Integer> prevlist : dp[t - candidates[j]]) {
                        if (candidates[j] >= prevlist.get(prevlist.size() - 1)) {
                            List temp = new ArrayList<>(prevlist);
                            temp.add(candidates[j]);
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    }

}
