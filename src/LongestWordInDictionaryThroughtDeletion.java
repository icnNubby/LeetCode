
import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/">Problem here.</a>
 * Created by NubbY
 */

public class LongestWordInDictionaryThroughtDeletion {
    private static final int stopper = 1001;

    public static void main(String[] args) {
        LongestWordInDictionaryThroughtDeletion test = new LongestWordInDictionaryThroughtDeletion();
        List<String> testDict = new ArrayList<>();
        testDict.add("abc");
        testDict.add("abbc");
        testDict.add("abbcc");
        System.out.println(test.findLongestWord("aabbbc", testDict));
    }

    private int difference(String s, String d) {
        if (s.length() < d.length()) {
            return stopper;
        }

        int indexS = 0;
        int counter = 0;

        for (int i = 0; i < d.length(); i++) {

            if (indexS >= s.length()) {
                return stopper;
            }

            while (s.charAt(indexS) != d.charAt(i)) {
                indexS++;
                counter++;
                if (indexS >= s.length()) {
                    return stopper;
                }
            }
            indexS++;

        }
        return counter + s.length() - indexS;
    }

    public String findLongestWord(String s, List<String> d) {
        int minCount = stopper; // cuz length of  strings is <= 1000
        String out = "";
        for (String word : d) {
            int diff = difference(s, word);
            if ((diff < minCount) ||
                    (diff == minCount && (!out.isEmpty() && word.compareTo(out) < 0))) {
                out = word;
                minCount = diff;
            }
        }
        return out;
    }
}
