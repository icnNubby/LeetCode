import java.util.Arrays;
import java.util.List;

/**
 * <A href="https://leetcode.com/problems/word-break/">Problem here.</A>
 * <p></p>
 * Created by NubbY
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        System.out.println("true ?= " + test.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    private String uncovered(String initial, List<String> wordDict) {
        for (int i = 0; i < initial.length(); i++) {
            if (wordDict.contains(initial.substring(0, i))) {
                System.out.println(initial);
                if (i == initial.length() - 1) {
                    System.out.println("winnner");
                    return "";
                }
                String remains = uncovered(initial.substring(i), wordDict);
                //System.out.println(remains);
                if (remains.isEmpty()) {
                    return "";
                }
            }
        }
        return initial;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return uncovered(s, wordDict).isEmpty();
    }
}
