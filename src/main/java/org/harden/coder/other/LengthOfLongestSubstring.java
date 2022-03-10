package org.harden.coder.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        List<Character> window = new ArrayList<>();
        //游标会动
//        for (int i = 0; i < s.length(); i++) {
        int i=0;
        while (i<s.length()){
            char c = s.charAt(i);
            if (!window.contains(c)) {
                window.add(c);
                result = Math.max(result, window.size());
                i++;
            } else {

                for (int j = 0; j < window.size(); j++) {
                    if (window.contains(c)) {
                        window.remove(0);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        //abcabcbb ohvhjdml
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("ohvhjdml"));
    }
}
