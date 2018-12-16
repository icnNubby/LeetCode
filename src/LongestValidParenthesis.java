/**
 * <a href = "https://leetcode.com/problems/longest-valid-parentheses"> Problem here.</a>
 */


class LongestValidParenthesis {



	public int longestValidParetheses(String s) { // function returns a length of maximal valid subsequence of paretheses, ending at the end of string
		//int lastResetIndex = 0;
		int[] dp = new int[s.length()];
		int currentLongestSubstringLength = 0;
		

		for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == ')') {
					if (s.charAt(i - 1)=='(') {
						dp[i] = i > 2? dp[i - 2] + 2: 0;
					} else {
						if ((i - 1 - dp[i - 1]>0)&&(s.charAt(i - 1 - dp[i - 1])=='(')) {
							dp[i] = dp[i - 1] + ((i - dp[i - 1] > 2)? dp[i - dp[i - 1] - 2] + 2: 2); 
						}
					}
					
				
				currentLongestSubstringLength = Math.max(currentLongestSubstringLength, dp[i]);
			}
		}
		return currentLongestSubstringLength;
	}


	public static void main (String[] args ) {
		LongestValidParenthesis l = new LongestValidParenthesis();
		System.out.println(l.longestValidParetheses("()(())"));
	}
}
