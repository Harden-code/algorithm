package org.harden.coder.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 16:00
 * 文件说明：
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * </p>
 */
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        //不仅要确保char相等 还要确保个数也相等
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (char c : chars1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        // a b b c | a b c c
        for (char c : chars2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (char c : chars2) {
            if(!map1.containsKey(c)|| map1.get(c).equals(map2.get(c))){
                return false;
            }
        }
        return true;
    }
}
