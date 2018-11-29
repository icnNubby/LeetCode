/**
 * <a href = "https://leetcode.com/problems/flipping-an-image">Problem here.</a>
 */

public class FlippingAnImage {
    public static int invert(int bit)
    {
        return (bit==0) ? 1 : 0;
    }
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < ((A[i].length + 1)/2); j++) {
            	int tmp = A[i][A[i].length - j - 1];
            	A[i][A[i].length - j - 1] = invert(A[i][j]);
            	A[i][j] = invert(tmp);
            }
        }
        return A;
    }
    
    public static void main(String[] args) {
    	int[][] A = {{1,1,0,1},{1,0,0,1},{0,0,0,0},{1,1,1,1}};
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------");
    	A = flipAndInvertImage(A);
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.print("\n");
        }
    	
    }
    
}
