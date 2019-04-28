import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/triangle/">Problem here.</a>
 * Created by NubbY
 */
public class Triangle {
    public static void main(String[] args) {
        Triangle test = new Triangle();
        List<List<Integer>> testList = new ArrayList<>();

        testList.add(Collections.singletonList(2));
        testList.add(Arrays.asList(3, 4));
        testList.add(Arrays.asList(6, 5, 7));
        testList.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(test.minimumTotal(testList));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> paths = new ArrayList<>();
        paths.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> copyPaths = new ArrayList<>(paths);
            for (int j = 1; j < copyPaths.size(); j++) {
                int elemOne = copyPaths.get(j - 1);
                int elemCurr = copyPaths.get(j);
                paths.set(j, Math.min(elemOne, elemCurr) + triangle.get(i).get(j));
            }
            paths.set(0, copyPaths.get(0) + triangle.get(i).get(0));
            if (copyPaths.size() >= 1) {
                paths.add(copyPaths.get(copyPaths.size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < paths.size(); i++) {
            min = Math.min(min, paths.get(i));
        }
        return min;
    }
}
