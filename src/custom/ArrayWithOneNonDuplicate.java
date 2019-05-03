package custom;

/**
 * Not leetcode problem.
 * Created by NubbY
 */
public class ArrayWithOneNonDuplicate {

    public static void main(String[] args) {
        ArrayWithOneNonDuplicate test = new ArrayWithOneNonDuplicate();
        int[] testArray = {1, 1, 2, 2, 4, 5, 5, 6, 6};
        System.out.println(test.nonDuplicated(testArray));
    }

    private int nonDuplicated(int[] arr) {
        int out = 0;
        for (int i = 0; i < arr.length; i++) {
            out = out ^ arr[i];
        }
        return out;
    }
}
