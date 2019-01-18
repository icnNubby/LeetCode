import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/shortest-distance-to-a-character/">Problem here.</a>
 * Created by NubbY
 */
public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        ShortestDistanceToACharacter test = new ShortestDistanceToACharacter();
        String S = "loveleetcode";
        Character C = 'e';
        System.out.println(Arrays.toString(test.shortestToChar(S, C)));
    }

    public int[] shortestToChar(String S, char C) {
        int[] shortestDistances = new int[S.length()];
        int current = S.length() + 1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) current = 0;
            shortestDistances[i] = current;
            current++;
        }
        current = S.length() + 1;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) current = 0;
            shortestDistances[i] = Math.min(current, shortestDistances[i]);
            current++;
        }

        return shortestDistances;
    }
}
