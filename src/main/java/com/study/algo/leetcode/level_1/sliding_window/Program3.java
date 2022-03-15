package com.study.algo.leetcode.level_1.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Program3 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> chars = new HashSet<>();
        int r = 0;
        for (int l = 0; l < s.length(); ++l) {
            if (l != 0) {
                chars.remove(s.charAt(l -1));
            }

            while (r < s.length() && !chars.contains(s.charAt(r))) {
                chars.add(s.charAt(r));
                ++r;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public static void main(String[] args) {
        int result = new Program3().lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}
