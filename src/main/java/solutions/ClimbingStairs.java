package solutions;

/**
 * 70. Climbing Stairs
 */

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int n2 = 1;
        int n1 = 2;
        int res = 0;
        if (n < 3) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            res = n2 + n1;
            n2 = n1;
            n1 = res;
        }
        return res;
    }
}
