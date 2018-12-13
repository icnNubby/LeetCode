import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * <a href = "https://leetcode.com/problems/array-of-doubled-pairs/"> Problem here. </a>
 * @author Nubby
 *
 */

public class ArrayOfDoubledPairs {

	public boolean canReorderDoubled(int[] A) {

		HashMap<Integer, Integer> hashA = new HashMap<Integer, Integer>();

		for(int i = 0; i < A.length; i++) 
			hashA.put(A[i], hashA.getOrDefault(A[i], 0) + 1 );
		
        Integer[] sortedA = new Integer[A.length];
        for (int i = 0; i < A.length; i++)
        	sortedA[i] = A[i];
        
        Arrays.sort(sortedA, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) > Math.abs(o2)) return 1;
				if (Math.abs(o1) < Math.abs(o2)) return -1;
				return 0;
			}
			
		});
		
		for (int i = 0; i < sortedA.length; i++) {
			if (hashA.get(sortedA[i]) == 0) continue;
			if (hashA.getOrDefault(sortedA[i]*2, 0) > 0) {
				hashA.put(sortedA[i]*2, hashA.getOrDefault(sortedA[i]*2, 0) - 1);
				hashA.put(sortedA[i], hashA.getOrDefault(sortedA[i], 0) - 1);
			} else
				return false;
		}
        
		return true;
	}

	public static void main(String[] args) {

		ArrayOfDoubledPairs test = new ArrayOfDoubledPairs();
		System.out.println(test.canReorderDoubled(new int[] {1, 2, 4, 8, -1, -2, 0, 0, 10, 20})); // true
		System.out.println(test.canReorderDoubled(new int[] {1, 2, 4, 8, -1, 2, 0, 0})); // false
		System.out.println(test.canReorderDoubled(new int[] {-2, -2, 1, -2, -1, 2})); // false
		System.out.println(test.canReorderDoubled(new int[] {4,-2,2,-4})); // true

	}

}

