// https://leetcode.com/problems/validate-stack-sequences/

import java.util.Stack;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
    	
    	if (pushed.length == 0) return true;
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	int i2 = 0;
    	for (int i1 = 0; i1 < pushed.length; i1++) {
        	stack.push(pushed[i1]);
    		while (!stack.empty() && stack.peek() == popped[i2]) {
    			stack.pop();
    			i2++;
    		} 
    	}
    
        return stack.empty();
    }
    
    public static void main(String[] args) {
    	int[] pushed = {1,2,3,4,5};
    	int[] popped = {4,5,3,1,2};
    	System.out.println(validateStackSequences(pushed, popped));
    }
}
 	