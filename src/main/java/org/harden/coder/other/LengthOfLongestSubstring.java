package org.harden.coder.other;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        Set<Character> window = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!window.contains(c)) {
                window.add(c);
                result = Math.max(result, window.size());
            } else {
                for (int j = 0; j < i; j++) {
                    if (window.contains(c)) {
                        window.remove(s.charAt(j));
                    }
                }
                window.add(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("aabaab!bb"));
    }
}
