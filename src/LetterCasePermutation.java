import java.util.ArrayList;
import java.util.List;

/**
 * <a href ="https://leetcode.com/problems/letter-case-permutation/" Problem here.
 */
public class LetterCasePermutation {

    private ArrayList<String> perms = new ArrayList<>();
    private int lengthS = 0;

    public static void main(String[] args) {
        LetterCasePermutation test = new LetterCasePermutation();
        for (String s : test.letterCasePermutation("abab"))
            System.out.println(s);
    }

    private void generatePermutations(char[] s, int pos) {
        if (pos == lengthS) {
            perms.add(String.valueOf(s));
            return;
        }
        if (!Character.isDigit(s[pos])) {
            s[pos] = Character.toUpperCase(s[pos]);
            generatePermutations(s, pos + 1);
            s[pos] = Character.toLowerCase(s[pos]);
            generatePermutations(s, pos + 1);
        } else
            generatePermutations(s, pos + 1);
    }

    public List<String> letterCasePermutation(String S) {
        lengthS = S.length();
        generatePermutations(S.toCharArray(), 0);
        return perms;
    }
}
