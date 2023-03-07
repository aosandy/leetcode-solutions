package solutions;

/**
 * 704. Binary Search
 */

public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static int firstBadVersion(int n) {
        int l = 0;
        int r = n - 1;
        int mid = 0;
        boolean res = false;
        while (r - l >= 0) {
            mid = (r - l) / 2 + l;
            res = isBadVersion(mid + 1);
            if (res) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (res ? mid + 1 : mid + 2);
    }
}
