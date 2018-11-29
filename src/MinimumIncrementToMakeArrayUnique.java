import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href = "https://leetcode.com/problems/minimum-increment-to-make-array-unique/">Problem here.</a>
 * @author Nubby
 *
 */
public class MinimumIncrementToMakeArrayUnique {
    public static int minIncrementForUnique(int[] A) {
    	if (A.length <= 1) return 0;
        Arrays.sort(A); 
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int totalIncrement = 0;
        int virtualMaximum = A[0];

        for (int i = 1; i < A.length; i++) {
        	virtualMaximum = A[i];
        	if (A[i] == A[i-1]) {
        		stack.add(i);
        	}
        	while (!stack.isEmpty() && i < A.length - 1 && virtualMaximum < A[i+1] - 1) {
        		totalIncrement += virtualMaximum - A[stack.pop()] + 1;
        		virtualMaximum++;
        	}
        }
    	while (!stack.isEmpty()) {
    		totalIncrement += virtualMaximum - A[stack.pop()] + 1;
    		virtualMaximum++;
    	}
        
        return totalIncrement;
    }

    public static void main(String[] args){
    	int[] A = {2,2,1,3,3,4,500};
    	System.out.println(minIncrementForUnique(A));
    }
    
}
