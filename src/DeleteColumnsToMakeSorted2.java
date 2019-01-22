/**
 * <a href = "https://leetcode.com/problems/delete-columns-to-make-sorted-ii/">Problem here.</a>
 * Created by NubbY
 */
public class DeleteColumnsToMakeSorted2 {
    public static void main(String[] args) {
        DeleteColumnsToMakeSorted2 test = new DeleteColumnsToMakeSorted2();
        String[] testArray = {"ca", "bb", "ac"};
        System.out.println(test.minDeletionSize(testArray));
    }

    public int minDeletionSize(String[] A) {

        int deletion = 0;
        boolean[] buckets = new boolean[A.length - 1];
        for (int i = 0; i < A[0].length(); i++) {
            boolean deleted = false;
            for (int j = 1; j < A.length; j++) {
                if (!buckets[j - 1] && A[j].charAt(i) < A[j - 1].charAt(i)) {
                    deletion++;
                    deleted = true;
                    break;
                }
            }
            boolean allSorted = true;
            if (!deleted) {
                for (int j = 0; j < A.length - 1; j++) {
                    if (A[j].charAt(i) < A[j + 1].charAt(i)) {
                        buckets[j] = true;
                    } else {
                        allSorted = false;
                    }
                }
            }
            if (allSorted && !deleted) return deletion;
        }
        return deletion;
    }

}
