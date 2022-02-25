package com.study.algo.leetcode.double_point;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Program283 {
    /**
     * 快慢指针，慢指针存结果，快指针进行校验
     */
    public void moveZeroes(int[] nums) {
        int q = 0;
        int s = 0;
        while (s < nums.length) {
            if (nums[s] == 0) {
                ++s;
                continue;
            }

            if (q == s) {
                ++q;
                ++s;
                continue;
            }

            int tmp = nums[q];
            nums[q] = nums[s];
            nums[s] = tmp;

            ++q;
            ++s;
        }
    }
}
