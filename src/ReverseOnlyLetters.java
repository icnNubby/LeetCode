/**
 * <a href = "https://leetcode.com/problems/reverse-only-letters/"> Problem here. </a>
 * @author Nubby
 *
 */
public class ReverseOnlyLetters {
	
    public String reverseOnlyLetters(String S) {
    	int start = 0;
    	int end = S.length() - 1;
    	StringBuilder out = new StringBuilder(S);
    	while (true) {
    		while (start < S.length() -1 && !Character.isLetter(S.charAt(start))) start++;
    		while (end > 0 && !Character.isLetter(S.charAt(end))) end--;
    		if (start >= end) return out.toString(); 
    		out.setCharAt(start, S.charAt(end));
    		out.setCharAt(end, S.charAt(start));
    		start++;
    		end--;
    	}
    }
	
    public static void main(String[] args) {
    	ReverseOnlyLetters test = new ReverseOnlyLetters();
    	System.out.println(test.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // "Qedo1ct-eeLg=ntse-T!"
    }
}
