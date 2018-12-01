/**
 * <a href = "https://leetcode.com/problems/valid-mountain-array/"> Problem is here. </a>
 * @author Nubby
 *
 */
public class ValidMountainArray {
    public static boolean validMountainArray(int[] A) {
        int peekIndex = 0;
        boolean goingUp = true;
        for(int i = 1; i < A.length; i++) {
            if (goingUp) {
                if (A[i] > A[i-1]) continue;
                else if (A[i] == A[i-1]) return false; 
                else {
                    goingUp = false;
                    if (peekIndex != 0) return false;
                    peekIndex = i - 1;
                }
            } else {
                if (A[i] < A[i-1]) continue;
                else if (A[i] == A[i-1]) return false; 
                else return false;
            }
        }
        if (peekIndex != 0) return true; else return false;
    }
    
    public static void main(String[] args) {
    	int[] A = {3,5,6,1};
    	System.out.println(validMountainArray(A));
    }
}
