/**
 * <a href = "https://leetcode.com/problems/partition-to-k-equal-sum-subsets/">Problem here.</a>
 * Created by NubbY
 * //todo timelimit fail!
 */
public class PartitionToKEqualSubsets {


    public static void main(String[] args) {
        int[] testArray = {4, 3, 2, 3, 5, 2, 1};
        int testK = 4;
        PartitionToKEqualSubsets test = new PartitionToKEqualSubsets();
        System.out.println(test.canPartitionKSubsets(testArray, testK));
    }

    private boolean checkPartition(int[] nums, int[] part, int k) {
        int[] sums = new int[k];
        for (int i = 0; i < nums.length; i++) {
            sums[part[i]] += nums[i];
        }
        int checkSum = sums[0];
        for (int i = 1; i < sums.length; i++) {
            if (sums[i] != checkSum) return false;
        }
        return true;
    }

    private boolean generateNextPartition(int[] part, int k) {
        int index = 0;
        while (index < part.length && part[index] == k - 1) {
            index++;
        }
        if (index == part.length) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            part[i] = 0;
        }
        part[index]++;
        return true;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] partition = new int[nums.length];
        do {
            if (checkPartition(nums, partition, k)) return true;
        } while (generateNextPartition(partition, k));

        return false;
    }
}

