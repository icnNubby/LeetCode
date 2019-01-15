import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href = "https://leetcode.com/problems/advantage-shuffle/">Problem here.</a>
 */
public class AdvantageShuffle {
    public static void main(String[] args) {
        int[] A = {12, 24, 8, 32};
        int[] B = {13, 25, 32, 11};
        AdvantageShuffle test = new AdvantageShuffle();
        System.out.println(Arrays.toString(test.advantageCount(A, B)));
    }

    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> bToTree = new TreeMap<>();
        for (int aElem : A)
            bToTree.put(aElem, bToTree.getOrDefault(aElem, 0) + 1);

        int[] outputArray = new int[B.length];
        int i = 0;
        for (int bElem : B) {
            Map.Entry<Integer, Integer> ceilingEntry = bToTree.ceilingEntry(bElem);
            Integer ceiling;
            if (ceilingEntry != null) {
                ceiling = bToTree.ceilingEntry(bElem).getKey();
                if (ceiling == bElem) {
                    ceiling = bToTree.higherKey(bElem);
                    if (ceiling == null) {
                        ceiling = bToTree.firstKey();
                    }
                }
            } else {
                ceiling = bToTree.firstKey();
            }
            if (bToTree.get(ceiling) > 0) {
                outputArray[i] = ceiling;
                bToTree.put(ceiling, bToTree.get(ceiling) - 1);
                if (bToTree.get(ceiling) == 0) bToTree.remove(ceiling);
            } else {
                System.out.println("Bad thing happened!");
            }
            i++;
        }
        return outputArray;
    }

}
