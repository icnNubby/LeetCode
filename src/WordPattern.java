import java.util.HashMap;
import java.util.HashSet;

/**
 * <a href = "https://leetcode.com/problems/word-pattern/">Problem here.</a>
 * Created by NubbY
 */
public class WordPattern {
    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        System.out.println(test.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (split.length != pattern.length()) return false;
        HashMap<Character, String> matchers = new HashMap<>();
        HashSet<String> allWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (matchers.get(pattern.charAt(i)) == null) {
                matchers.put(pattern.charAt(i), split[i]);
                if (allWords.contains(split[i])) {
                    return false;
                } else {
                    allWords.add(split[i]);
                }
            } else {
                if (!matchers.get(pattern.charAt(i)).equals(split[i]))
                    return false;
            }
        }
        return true;
    }
}
