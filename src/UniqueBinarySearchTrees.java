/**
 * <a href = "https://leetcode.com/problems/unique-binary-search-trees/">Problem here.</a>
 * Created by NubbY
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        System.out.println(test.numTrees(100));
    }

    public int numTrees(int n) {

        int[] numTreesStore = new int[n + 1];

        numTreesStore[0] = 1;
        numTreesStore[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                numTreesStore[i] += numTreesStore[j - 1] * numTreesStore[i - j];
            }
        }

        return numTreesStore[n];
    }
}
