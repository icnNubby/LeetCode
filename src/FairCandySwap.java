import java.util.HashSet;
/**
 *<a href="https://leetcode.com/problems/fair-candy-swap/">Problem here. <a>
 * @author Nubby
 *
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
    	long Asum = 0;
    	long Bsum = 0;
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i = 0; i < A.length; i++) {
    		Asum+=A[i];
    	}
    	for(int i = 0; i < B.length; i++) {
    		Bsum+=B[i];
    		set.add(B[i]);
    	}
    	for(int i = 0; i < A.length; i++) {
    		if ((Bsum-Asum)%2 == 0) 
    			if (set.contains((int)(Bsum - Asum)/2 + A[i])) {
    				int[] out = new int[2];
    				out[0] = A[i]; out[1] = (int) ((Bsum - Asum)/2 + A[i]);
    				return out;
    			}
    		}
        return null;
    }
}
