package solutions;


/**
 * 704. Binary Search
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (r - l >= 0) {
            int mid = (r - l) / 2 + l;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
