import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> splittedAB = new ArrayList<>(Arrays.asList((A + " " + B).split(" ")));
        List<String> out = new ArrayList<>();
        while (splittedAB.size() > 0) {
            String copy = splittedAB.get(0);
            splittedAB.remove(copy);
            if (splittedAB.indexOf(copy) >= 0) {
                while (splittedAB.indexOf(copy) >= 0)
                    splittedAB.remove(copy);
            } else {
                out.add(copy);
            }
        }

        String[] outArr = new String[out.size()];
        for (int i = 0; i < out.size(); i++)
            outArr[i] = out.get(i);
        return outArr;
    }
}
