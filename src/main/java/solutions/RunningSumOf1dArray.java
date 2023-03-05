package solutions;

import java.util.List;

/**
 * 1480. Running Sum of 1d Array
 */

public class RunningSumOf1dArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ans = runningSum(nums);
        System.out.println(List.of(ans));
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}
