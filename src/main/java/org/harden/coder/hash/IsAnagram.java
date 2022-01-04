package org.harden.coder.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 16:19
 * 文件说明： </p>
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map1.containsKey(c) || !map1.get(c).equals(map2.get(c))) {
                return false;
            }
        }
        return true;
    }
}
