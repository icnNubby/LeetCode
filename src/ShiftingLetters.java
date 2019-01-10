/**
 * <a href = "https://leetcode.com/problems/shifting-letters/">Problem here.</a>
 */
public class ShiftingLetters {
    public static void main(String[] args) {
        ShiftingLetters test = new ShiftingLetters();
        int[] testArray = {26};
        String s = "a";
        String testOut = test.shiftingLetters(s, testArray);
        System.out.println(testOut);
    }

    private char shiftLetter(char c, int shift) {
        return (char) (97 + (((int) c - 97) + shift) % 26);
    }

    public String shiftingLetters(String S, int[] shifts) {
        char[] shifted = new char[S.length()];
        for (int i = S.length() - 1; i >= 0; i--) {
            if (i > 0) shifts[i - 1] += shifts[i] % 26;
            shifted[i] = shiftLetter(S.charAt(i), shifts[i]);
        }
        return new String(shifted);
    }
}
