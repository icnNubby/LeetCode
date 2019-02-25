import java.util.HashMap;

/**
 * <a href = "https://leetcode.com/problems/find-the-town-judge/">Problem here.</a>
 * Created by NubbY
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        int testN = 4;
        int[][] testTrust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(new FindTheTownJudge().findJudge(testN, testTrust));
    }

    public int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> trustTable = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            trustTable.put(trust[i][1], trustTable.getOrDefault(trust[i][1], 0) + 1);
            trustTable.put(trust[i][0], trustTable.getOrDefault(trust[i][0], 0) - 1);
        }
        int out = -1;
        for (int i = 1; i <= N; i++) {
            if (trustTable.getOrDefault(i, -1) == N - 1) {
                out = i;
            }
        }
        return out;
    }
}
