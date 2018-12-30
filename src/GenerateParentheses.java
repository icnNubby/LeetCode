import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/generate-parentheses/">Problem here.</a>
 */

public class GenerateParentheses {
    private List<String> allParentheses = new ArrayList<>();

    public static void main(String... args) {
        GenerateParentheses test = new GenerateParentheses();
        List<String> testList = test.generateParenthesis(2);
        for (String str : testList) System.out.println(str);
    }

    private void generateRecursive(String input, int max, int left, int right) {
        if (left == right && left == max) {
            allParentheses.add(input);
            return;
        }
        if (left < max) {
            generateRecursive(input + "(", max, left + 1, right);
        }
        if (right < left) {
            generateRecursive(input + ")", max, left, right + 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        generateRecursive("", n, 0, 0);
        return allParentheses;
    }
}
