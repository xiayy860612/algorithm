package com.study.algo.leetcode.level_1.bfs_dfs;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class Program733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (sr < 0 || sr >= image.length) {
            return image;
        }

        if (sc < 0 || sc >= image[0].length) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int origin, int newColor) {
        if (sr < 0 || sr >= image.length) {
            return;
        }

        if (sc < 0 || sc >= image[0].length) {
            return;
        }

        if (image[sr][sc] != origin || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;

        dfs(image, sr - 1, sc, origin, newColor);
        dfs(image, sr + 1, sc, origin, newColor);
        dfs(image, sr, sc - 1, origin, newColor);
        dfs(image, sr, sc + 1, origin, newColor);
    }
}
