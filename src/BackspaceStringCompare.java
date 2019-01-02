/**
 * 	<a href = "https://leetcode.com/problems/backspace-string-compare/"> Problem here. </a> 
 *
 * @author icnNubby
 *
 */
public class BackspaceStringCompare {  

	//bad implementation, long is not big enough for conditions of the task

	/*	public long convertStringToHash(String s) {
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
	}*/



	public boolean backspaceCompare(String S, String T) {
		int counterS = S.length() - 1;
		int counterT = T.length() - 1;
		int backspacesS = 0;
		int backspacesT = 0;

		while (true) {
			char letterS = '!';
			char letterT = '!';
		
			for (; counterS >= 0; counterS--) {
				if (S.charAt(counterS) != '#') {
					if (backspacesS == 0) {
						letterS = S.charAt(counterS);
						counterS--;						 // dont forget to move 1 symbol further
						break;
					} else 
						backspacesS--;
					
				} else 
					backspacesS++;
			}

			for (; counterT >= 0; counterT--) {
				if (T.charAt(counterT) != '#') {
					if (backspacesT == 0) {
						letterT = T.charAt(counterT);
						counterT--; 					// dont forget to move 1 symbol further
						break;
					} else 
						backspacesT--;
					
				} else 
					backspacesT++;
			}

			if (counterT == -1 && counterS == -1)
				return letterS == letterT;
			if (letterT != letterS) return false;
		}	
	}


	public static void main(String[] args) {
		String S = "xywrrmp";
		String T = "xywrrmu#p";
		BackspaceStringCompare test = new BackspaceStringCompare();
		System.out.println(test.backspaceCompare(S, T));	//true
	}
}
