package solutions;

import java.util.Arrays;

/**
 * 62. Unique Paths
 */

public class UniquePaths {
    private static int[][] paths;

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        paths = new int[m][n];
        Arrays.fill(paths[0], 1);
        for (int i = 1; i < m; i++) {
            paths[i][0] = 1;
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}
