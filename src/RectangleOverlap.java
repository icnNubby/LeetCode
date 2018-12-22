/**
 *  <a href = "https://leetcode.com/problems/rectangle-overlap/"> Problem here. </a> 
 * @author icnNubby
 *
 */
public class RectangleOverlap {

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		boolean rec2Outsiderec1 = 
				((rec1[0] >= rec2[2]) ||
				 (rec2[0] >= rec1[2]) ||
				 (rec1[1] >= rec2[3]) ||
				 (rec2[1] >= rec1[3]));
		return !rec2Outsiderec1;
	}
	
	
	public static void main(String[] args) {
		RectangleOverlap test = new RectangleOverlap();

		int[] rec1 = {0,0,2,2};
		int[] rec2 = {1,1,3,3};
		System.out.println(test.isRectangleOverlap(rec1, rec2));

		rec1 = new int[] {0,0,1,1};
		rec2 = new int[] {1,0,2,1};
		System.out.println(test.isRectangleOverlap(rec1, rec2));
		
	}
}
