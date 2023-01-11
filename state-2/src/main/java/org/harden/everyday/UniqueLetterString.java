package org.harden.everyday;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/6 9:46
 * 文件说明：统计子串中的唯一字符 hard</p>
 */
public class UniqueLetterString {
    private int dump;
    private Set<String> hash = new HashSet<>();

    public int uniqueLetterString(String s) {
        back(s, new ArrayList<>(), 0);
        for (String key : hash) {
            Map<Character, Integer> count = count(key);
            System.out.println(key + " " + count.size());
            dump += count.size();
        }
        return dump;
    }


    private void back(String chars, List<String> path, int index) {
        if (index >= chars.length()) {
            if (index == chars.length()) {
//                for (String s : path) {
//                    Map<Character, Integer> count = count(s);
//                    dump += count.size();
//                }
//                System.out.println(path.toString());
                hash.addAll(path);
            }
            return;
        }

        for (int i = 1; i <= chars.length(); i++) {
            //切割
            if (index + i > chars.length()) {
                return;
            }
            String sub = chars.substring(index, index + i);
            path.add(sub);
            back(chars, path, index + i);
            path.remove(path.size() - 1);
        }
    }

//    public String key(Map<Character, Integer> map) {
//        StringBuilder builder = new StringBuilder();
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            builder.append(entry.getKey());
//        }
//        String string = builder.toString();
//        char[] chars = string.toCharArray();
//        Arrays.sort(chars);
//        return new String(chars);
//    }

    public Map<Character, Integer> count(String path) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

//    public int countUniqueChars(char[] s) {
////        int result = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length; i++) {
//            char c = s[i];
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
////        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
////            int i = entry.getValue();
////            if (i == 1) {
////                result++;
////            }
////        }
//        return map.size();
//    }

    public static void main(String[] args) {
        UniqueLetterString uni = new UniqueLetterString();
        System.out.println(uni.uniqueLetterString("leet"));
//            System.out.println(uni.uniqueLetterString("abcd"));
    }
}
