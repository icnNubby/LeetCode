import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/uncommon-words-from-two-sentences/">Problem here.</a>
 * Created by NubbY
 */
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        UncommonWordsFromTwoSentences test = new UncommonWordsFromTwoSentences();
        String A = "apple apple";
        String B = "banana";
        String[] testArr = test.uncommonFromSentences(A, B);
        System.out.println(Arrays.toString(testArr));
    }

    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> splittedAB = new HashMap<>();
        for (String item : (A + " " + B).split(" ")) {
            splittedAB.put(item, splittedAB.getOrDefault(item, 0) + 1);
        }
        List<String> out = new ArrayList<>();
        for (String item : splittedAB.keySet())
            if (splittedAB.get(item) == 1) out.add(item);

        return out.toArray(new String[0]);
    }
}
