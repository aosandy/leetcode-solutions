package solutions;

import java.util.Arrays;

/**
 * 733. Flood Fill
 */

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] res = floodFill(image, 1, 1, 2);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        return dfs(image, sr, sc, oldColor, color, image.length, image[0].length);
    }

    public static int[][] dfs(int[][] image, int i, int j, int oldColor, int color, int m, int n) {
        if (image[i][j] == oldColor) {
            image[i][j] = color;
        } else {
            return image;
        }
        if (i > 0) {
            image = dfs(image, i - 1, j ,oldColor, color, m, n);
        }
        if (i < m - 1) {
            image = dfs(image, i + 1, j ,oldColor, color, m, n);
        }
        if (j > 0) {
            image = dfs(image, i, j - 1 ,oldColor, color, m, n);
        }
        if (j < n - 1) {
            image = dfs(image, i, j + 1 ,oldColor, color, m, n);
        }
        return image;
    }
}
