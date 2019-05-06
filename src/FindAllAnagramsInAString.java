import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/find-all-anagrams-in-a-string/">Problem here.</a>
 * Created by NubbY
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        FindAllAnagramsInAString test = new FindAllAnagramsInAString();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
    }

    private boolean isAnagram(HashMap<Character, Integer> counter) {
        for (Character key : counter.keySet())
            if (counter.get(key) != 0) return false;
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> outIndices = new ArrayList<>();

        if (s.length() < p.length()) {
            return outIndices;
        }

        HashMap<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            if (counter.get(p.charAt(i)) == null) {
                counter.put(p.charAt(i), 1);
            } else {
                counter.put(p.charAt(i), counter.get(p.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < p.length(); i++) {
            if (counter.get(s.charAt(i)) != null) {
                counter.put(s.charAt(i), counter.get(s.charAt(i)) - 1);
            }
        }
        if (isAnagram(counter)) {
            outIndices.add(0);
        }


        for (int i = p.length(); i < s.length(); i++) {
            if (counter.get(s.charAt(i)) != null) {
                counter.put(s.charAt(i), counter.get(s.charAt(i)) - 1);
            }
            int index = i - p.length();
            if (counter.get(s.charAt(index)) != null) {
                counter.put(s.charAt(index), counter.get(s.charAt(index)) + 1);
            }
            if (isAnagram(counter)) {
                outIndices.add(i - p.length() + 1);
            }
        }

        return outIndices;
    }
}
