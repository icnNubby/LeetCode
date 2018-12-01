import java.util.HashSet;

/**
 * <a href = "https://leetcode.com/problems/minimum-area-rectangle/"> Problem is here. </a>
 * @author Nubby
 *
 */
public class MinimumAreaRectangle {
    public static int minAreaRect(int[][] points) {
    	
    	if (points.length < 4) return 0;
    	
    	int min = Integer.MAX_VALUE;
    	HashSet<Integer> set = new HashSet<Integer>();
    	
    	for(int i = 0; i < points.length; i++) 
    		set.add(points[i][0]*40001 + points[i][1]);
    	
    	for(int i = 0; i < points.length - 1; i++)
    		for(int j = i + 1; j < points.length; j++) {
    			if ((points[i][0] != points[j][0])&& (points[i][1] != points[j][1]))
    			if (set.contains(points[i][0]*40001 + points[j][1])&&
    				set.contains(points[j][0]*40001 + points[i][1])) {
    				min = Math.min(min, 
    						Math.abs(points[i][0] - points[j][0])*
    						Math.abs(points[i][1] - points[j][1])); 
    			}
    		}
    	
        return (min == Integer.MAX_VALUE)? 0 : min;
    }
    
    public static void main(String[] args) {
    	int[][]A  = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
    	System.out.println(minAreaRect(A));
    }
}
