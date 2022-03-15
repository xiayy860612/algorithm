package com.study.algo.leetcode.level_1.double_point;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class Program977 {

    /**
     * 找到负数和非负数的分割点，
     * 左边为负数，平方后为降序；
     * 右边为非负数，平方和升序；
     *
     * 双指针，对两边的元素从小到大进行比较；
     * 将较小的一个存下来，移动指针，继续比较
     */
    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int negative = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (-nums[i] < nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }
        return ans;
    }

    /**
     * 左右元素的平方比较，取较大值;
     * 移动指针，继续比较；
     */
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int index = nums.length - 1;
        while (index >= 0) {
            if (-nums[l] > nums[r]) {
                ans[index] = nums[l] * nums[l];
                ++l;
                --index;
            } else {
                ans[index] = nums[r] * nums[r];
                --r;
                --index;
            }
        }
        return ans;
    }
}
