package com.study.algo.leetcode.level_1.sliding_window;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。
 * 如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 由于排列不会改变字符串中每个字符的个数，
 * 所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
 */
public class Program567 {
    public boolean checkInclusion_1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt)) {
            return true;
        }

        for (int i = n; i < m; ++i) {
            ++cnt[s2.charAt(i) - 'a'];
            --cnt[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion_2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }

        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }

        if (diff == 0) {
            return true;
        }

        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a';
            int y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }

            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }

            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }

            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion_3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            --cnt[s1.charAt(i) - 'a'];
        }

        int left = 0;
        for (int right = 0; right < m; right++) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }

            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
