import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * <a href = "https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/solution/"> Problem here. </a>
 */
public class MostStonesRemovedWithSameRowOrColumn {
	public static int removeStones(int[][] stones) {
		int N = stones.length;
		DSU dsu = new DSU(20000);

		for (int[] stone : stones)
			dsu.union(stone[0], stone[1] + 10000);
		Set<Integer> seen = new HashSet<>();
		for (int[] stone : stones)
			seen.add(dsu.find(stone[0]));

		return N - seen.size();
	}
	
	static class DSU {
		private final int[] Elements;

		public DSU(int N) {
			Elements = new int[N];
			for (int i = 0; i < N; i++) Elements[i] = i;
		}

		public void makeSet(int x) {
			Elements[x] = x;
		}

		public int find(int x) //Search for the root and rejoining all the childs to the root
		{
			if (Elements[x] == x) return x;
			Elements[x] = find(Elements[x]);
			return Elements[x];
		}

		public void union(int x, int y) {
			if ((new Random(2).nextInt()) == 1) // random choice to decide which element will be new root
				Elements[find(x)] = find(y);
			else
				Elements[find(y)] = find(x);
	    }

	}
	
    public static void main(String[] args) {
    	int[][] A = {{0,0},{1,2},{2,1},{2,2}};
    	System.out.println(removeStones(A));
    }
    
}
