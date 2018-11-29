/**
 * <a href = "https://leetcode.com/problems/first-missing-positive"> Problem here. </a>
 */
public class FirstMissingPositive {
	public static int solution(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				nums[i] = Integer.MAX_VALUE; 
			} 
		}
		for (int i = 0; i < nums.length; i++) {
			if (Math.abs(nums[i]) <= nums.length && Math.abs(nums[i]) > 0) {
				nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
			}
		}
		int min = 1;
		while (min - 1 < nums.length && nums[min - 1] < 0) {
			min++;
		}
		return min;
	}
	public static void main(String[] args) {
		int[] a = new int[] { 3,4,-1,1};
		System.out.println(solution(a));
	}
}
