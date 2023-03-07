package solutions;

/**
 * 509. Fibonacci Number
 */

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        int n2 = 0;
        int n1 = 1;
        int res = 1;
        if (n < 2) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            res = n2 + n1;
            n2 = n1;
            n1 = res;
        }
        return res;
    }
}
