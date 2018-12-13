import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/sort-array-by-parity-ii/"> Problem here. </a>
 * @author Nubby
 *
 */
public class SortArrayByParity2 {
	
	public boolean isOdd(int n) {return n%2==0;}
	
    public int[] sortArrayByParityII(int[] A) {
    	int oddCounter = 0;
    	int evenCounter = 1;
    	while (true) {
    		while (oddCounter < A.length && isOdd(A[oddCounter])) oddCounter += 2;
    		while (evenCounter < A.length && !isOdd(A[evenCounter])) evenCounter += 2;
    		if (oddCounter >= A.length || evenCounter >= A.length) return A;
    		int temp = A[oddCounter];
    		A[oddCounter] = A[evenCounter];
    		A[evenCounter] = temp;     		
    	}
    }
    
    public static void main(String[] args) {
    	SortArrayByParity2 test = new SortArrayByParity2();
    	int[] out = test.sortArrayByParityII(new int [] {1,2,3,4,5,6});
    	System.out.println(Arrays.toString(out));
    }
}
