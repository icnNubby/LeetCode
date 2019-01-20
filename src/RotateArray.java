import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/rotate-array/">Problem here.</a>
 * Inplace O(N) solution
 * Created by NubbY
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] testArray = new int[15];
        for (int i = 0; i < testArray.length; i++) testArray[i] = i + 1;
        int testK = 10;
        RotateArray test = new RotateArray();
        test.rotate(testArray, testK);
        System.out.println(Arrays.toString(testArray));

        testArray = new int[29];
        for (int i = 0; i < testArray.length; i++) testArray[i] = i + 1;
        testK = 5;
        test.rotate(testArray, testK);
        System.out.println(Arrays.toString(testArray));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        boolean typeOfRotation = k == 1;
        int maxDenominator = 1;
        int len = nums.length;
        int kCopy = k;
        for (int i = 2; i <= kCopy + 1; i++) {
            if (len % i == 0 && kCopy % i == 0) {
                typeOfRotation = true;
                maxDenominator *= i;
                len /= i;
                kCopy /= i;
                i = 1;
            }
        }
        if (typeOfRotation) {
            for (int i = 0; i < maxDenominator; i++) {
                int first = nums[i];
                int temp;
                for (int j = 1; j < nums.length / maxDenominator; j++) {
                    temp = nums[(k * j + i) % nums.length];
                    nums[(k * j + i) % nums.length] = first;
                    first = temp;
                }
                nums[i] = first;
            }
        } else {
            int prev = nums[0];
            int temp;
            int index = k;
            for (int i = 1; i < nums.length; i++) {
                temp = nums[index];
                nums[index] = prev;
                prev = temp;
                index = (index + k) % nums.length;
            }
            nums[0] = prev;
        }
    }

}
