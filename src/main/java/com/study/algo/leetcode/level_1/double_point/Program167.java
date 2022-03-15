package com.study.algo.leetcode.level_1.double_point;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class Program167 {
    public int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> restMap = new LinkedHashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            int rest = target - numbers[i];
            if (restMap.containsKey(rest)) {
                return new int[] {restMap.get(rest), i+1};
            }

            restMap.put(numbers[i], i + 1);
        }
        return new int[] {-1, -1};
    }


    /**
     * 双指针
     */
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int res = numbers[l] + numbers[r];
            if (res == target) {
                return new int[] {l + 1, r+1};
            }

            if (res < target) {
                ++l;
                continue;
            }

            --r;
        }
        return new int[] {-1, -1};
    }
}
