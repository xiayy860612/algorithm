package com.study.algo.leetcode.double_point;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Program344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            ++l;
            --r;
        }
    }
}
