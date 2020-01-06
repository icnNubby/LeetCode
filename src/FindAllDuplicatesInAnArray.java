import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * * <a href = "https://leetcode.com/problems/find-all-duplicates-in-an-array/">Problem here.</a>
 * <p>
 * Created by NubbY
 */
public class FindAllDuplicatesInAnArray {

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int numberToCheck = nums[i];
            int indexToChange = Math.abs(numberToCheck) - 1;
            if (nums[indexToChange] < 0) {
                result.add(Math.abs(numberToCheck));
            }
            nums[indexToChange] = -nums[indexToChange];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> testResult = findDuplicates(test);

        System.out.println(testResult.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));
    }
}
