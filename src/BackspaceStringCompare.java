/**
 * 	<a href = "https://leetcode.com/problems/backspace-string-compare/"> Problem here. </a> 
 *
 * @author icnNubby
 *
 */
public class BackspaceStringCompare {
	
	public long convertStringToHash(String s) {
		long out = 0;
		long pow27 = 1;
		int backspaces = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != '#') {
				if (backspaces > 0) {
					backspaces--;
				} else {
					pow27 *= 27;
					out += pow27 * ((int)s.charAt(i) - 96);
				}
			} else 
				backspaces++;
		}
		return out;
	}

	public boolean backspaceCompare(String S, String T) {
		return (convertStringToHash(S) == convertStringToHash(T));
	}
	
	public static void main(String[] args) {
		String S = "ab#c";
		String T = "ad#c";
		BackspaceStringCompare test = new BackspaceStringCompare();
		System.out.println(test.backspaceCompare(S, T));
	}
}
