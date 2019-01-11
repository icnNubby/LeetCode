import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/subsets-ii/">Problem here.</a>
 */
public class Subsets2 {

    private HashMap<Integer, Integer> numsHashed = new HashMap<>();
    private ArrayList<Tuple> indices = new ArrayList<>();

    public static void main(String[] args) {
        Subsets2 test = new Subsets2();
        int[] testArray = {1, 2, 2, 3, 3};
        List<List<Integer>> testList = test.subsetsWithDup(testArray);
        for (List<Integer> line : testList) {
            System.out.println(Arrays.toString(line.toArray()));
        }
    }

    private boolean stepFurther() {
        boolean canStepFurther = false;
        for (int i = 0; i < indices.size(); i++) {
            if (indices.get(i).iterationValue < numsHashed.get(indices.get(i).keyIndex)) {
                for (int j = 0; j < i; j++) {
                    indices.get(j).iterationValue = 0;
                }
                indices.get(i).iterationValue++;
                canStepFurther = true;
                break;
            }
        }
        return canStepFurther;
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsHashed.put(nums[i], numsHashed.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer elem : numsHashed.keySet()) indices.add(new Tuple(elem, 0));
        do {
            ArrayList<Integer> oneElement = new ArrayList<>();
            for (int j = 0; j < indices.size(); j++) {
                for (int i = 0; i < indices.get(j).iterationValue; i++) {
                    oneElement.add(indices.get(j).keyIndex);
                }
            }
            out.add(oneElement);
        } while (stepFurther());
        return out;
    }

    private class Tuple {
        public int keyIndex;
        public int iterationValue;

        Tuple(int keyIndex, int iterationValue) {
            this.keyIndex = keyIndex;
            this.iterationValue = iterationValue;
        }
    }
}
