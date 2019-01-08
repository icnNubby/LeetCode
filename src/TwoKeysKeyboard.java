/**
 * <a href = "https://leetcode.com/problems/2-keys-keyboard">Problem here.</a>
 */
public class TwoKeysKeyboard {

    public static void main(String[] args) {
        TwoKeysKeyboard test = new TwoKeysKeyboard();
        System.out.println(test.minSteps(100));
    }

    public int minSteps(int n) {
        if (n == 1) return 0;
        if (n == 2) return 2;
        int i = 2;
        while (n % i != 0) i++;
        return minSteps(n / i) + i;
    }
}
