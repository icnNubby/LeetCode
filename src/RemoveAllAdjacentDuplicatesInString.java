import java.util.Stack;

/**
 * <a href = "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">Problem here</a>
 * <p>
 * </p>
 * Created by NubbY
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String testString = "abbaca";
        RemoveAllAdjacentDuplicatesInString test = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(test.removeDuplicates(testString));
    }

    private String makeStringFromStack(Stack<Character> stack) {
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        //we need to reverse stringBuilder, since we got characters in their reverse order from stack
        builder.reverse();
        return builder.toString();
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            Character currentCharacter = S.charAt(i);
            if (!stack.isEmpty()) {
                Character topCharacter = stack.peek();
                if (topCharacter.equals(currentCharacter)) {
                    stack.pop();
                } else {
                    stack.push(currentCharacter);
                }
            } else {
                stack.push(currentCharacter);
            }
        }
        return makeStringFromStack(stack);
    }
}
