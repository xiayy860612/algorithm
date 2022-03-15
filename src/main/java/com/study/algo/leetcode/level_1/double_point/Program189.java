package com.study.algo.leetcode.level_1.double_point;

import org.apache.commons.math3.util.ArithmeticUtils;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * <p>
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Program189 {
    /**
     * 空间复杂度: O(n)
     */
    public void rotate1(int[] nums, int k) {
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            copy[i] = nums[i];
        }

        for (int i = 0; i < copy.length; ++i) {
            int index = (i + k) % copy.length;
            nums[index] = copy[i];
        }
    }

    /**
     * 环状替换的理论分析:　
     * https://leetcode-cn.com/problems/rotate-array/solution/huan-zhuang-ti-huan-de-li-lun-fen-xi-by-qsingh/
     */
    public void rotate2(int[] nums, int k) {
        int m = ArithmeticUtils.lcm(nums.length, k) / k;
        int count = m < nums.length ? nums.length / m : 1;
        for (int i = 0; i < count; ++i) {
            int index = i;
            int value = nums[index];
            do {
                int dest = (index + k) % nums.length;
                int tmp = nums[dest];
                nums[dest] = value;

                value = tmp;
                index = dest;
            } while (index == i);
        }
    }

    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        rotateRange(nums, 0, nums.length - 1);
        rotateRange(nums, 0, k - 1);
        rotateRange(nums, k, nums.length - 1);
    }

    void rotateRange(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }


}
