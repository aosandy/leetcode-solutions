package solutions;

/**
 * 200. Number of Islands
 */

public class NumberOfIslands {

    private static int m;
    private static int n;

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},  
            {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0' || grid[i][j] == 'v') {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = 'v';
        }
        if (i > 0) {
            dfs(grid, i - 1, j);
        }
        if (i < m - 1) {
            dfs(grid, i + 1, j );
        }
        if (j > 0) {
            dfs(grid, i, j - 1);
        }
        if (j < n - 1) {
            dfs(grid, i, j + 1);
        }
    }
}
