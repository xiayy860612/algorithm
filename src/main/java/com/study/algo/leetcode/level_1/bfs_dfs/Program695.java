package com.study.algo.leetcode.level_1.bfs_dfs;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Program695 {

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int max = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; j++) {
                int area = dfs(grid, i, j);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= grid.length) {
            return 0;
        }

        if (colIndex < 0 || colIndex >= grid[0].length) {
            return 0;
        }

        if (grid[rowIndex][colIndex] == 0) {
            return 0;
        }

        grid[rowIndex][colIndex] = 0;

        int top = dfs(grid, rowIndex - 1, colIndex);
        int down = dfs(grid, rowIndex + 1, colIndex);
        int left = dfs(grid, rowIndex, colIndex - 1);
        int right = dfs(grid, rowIndex, colIndex + 1);
        return top + down + left + right + 1;
    }


}
