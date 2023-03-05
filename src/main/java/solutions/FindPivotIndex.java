package solutions;

import java.util.Arrays;

/**
 * 724. Find Pivot Index
 */

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int res = pivotIndex(nums);
        System.out.println(res);
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum() - nums[0];
        if (rightSum == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
