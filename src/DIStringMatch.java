/**
 *<a href = "https://leetcode.com/problems/di-string-match/"> Problem here. </a>
 */
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int curMin = 0;
        int curMax = S.length();
        int[] out = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                out[i] = curMin ++;
            } else {
                out[i] = curMax --;
            }
        }
        out[S.length()] = curMax;
        return out;
    }
}
