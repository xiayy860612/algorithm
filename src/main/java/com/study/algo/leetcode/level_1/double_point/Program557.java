package com.study.algo.leetcode.level_1.double_point;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Program557 {
    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int start = 0;
        int end = 0;
        while (end < ss.length) {
            if (ss[end] != ' ') {
                ++end;
                continue;
            }

            reverse(ss, start, end - 1);
            start = end + 1;
            while (start < ss.length) {
                if (ss[start] == ' ') {
                    ++start;
                }
                break;
            }
            end = start;
        }
        reverse(ss, start, end - 1);
        return new String(ss);
    }

    void reverse(char[] ss, int l, int r) {
        while (l < r) {
            char tmp = ss[l];
            ss[l] = ss[r];
            ss[r] = tmp;
            ++l;
            --r;
        }
    }
}
