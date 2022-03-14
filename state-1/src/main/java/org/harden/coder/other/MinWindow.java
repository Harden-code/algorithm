package org.harden.coder.other;

import com.sun.org.apache.xpath.internal.operations.Lt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/3/10 10:39
 * 文件说明：76. 最小覆盖子串 </p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        String result = "";
        int size = Integer.MAX_VALUE;
        if (s.length() < t.length()) {
            return result;
        }
        List<Character> window = new ArrayList<>();
        Set<Character> record = new HashSet<>();
        Set<Character> model = new HashSet<>();
        /**
         * s = "ADOBECODEBANC", t = "ABC" "BANC"
         */
        for (int i = 0; i < t.length(); i++) {
            model.add(t.charAt(i));
        }

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (model.contains(c) && !record.contains(c)) {
                //遇到a 并且窗口里没有a
                record.add(c);
                window.add(c);
                i++;
                //遇到重复
            } else if(model.contains(c) && record.contains(c)) {
                record.remove(c);
                window.remove(0);
                for (int j = 0; j < window.size(); j++) {
                    char a=window.get(0);
                    if(!model.contains(a)){
                        window.remove(0);
                    }else {
                        break;
                    }
                }
                record.add(c);
                window.add(c);
                i++;
            } else if(record.size()<t.length()&&!record.contains(c)&&!window.isEmpty()){
                //匹配当前字符且包含模板里的字符  ab b
                window.add(c);
                i++;
            }else {
                //没有匹配字符
                i++;
            }
            if(record.size() == t.length()){
                //缩减窗口
                if (window.size() < size) {
                    StringBuilder builder = new StringBuilder();
                    for (int j = 0; j < window.size(); j++) {
                        builder.append(window.get(j));
                    }
                    result = builder.toString();
                    size = window.size();
                }
                //删除前缀
                Character remove = window.remove(0);
                record.remove(remove);
                for (int j = 0; j < window.size(); j++) {
                    char w = window.get(0);
                    if (model.contains(w)) {
                        break;
                    } else {
                        window.remove(0);
                    }
                }
            }
        }
        return result;
    }


    public String minWindow1(String s, String t) {
        String result = "";
        int size = Integer.MAX_VALUE;
        if (s.length() < t.length()) {
            return result;
        }
        List<Character> window = new ArrayList<>();
        List<Character> record = new ArrayList<>();
        List<Character> model = new ArrayList<>();
        /**
         * s = "ADOBECODEBANC", t = "ABC" "BANC"
         */
        for (int i = 0; i < t.length(); i++) {
            model.add(t.charAt(i));
        }

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (model.contains(c) && !record.contains(c)) {
                //遇到a 并且窗口里没有a
                record.add(c);
                window.add(c);
                i++;
                //遇到重复
            } else if(model.contains(c) && record.contains(c)) {
                record.remove((Object)c);
                window.remove(0);
                for (int j = 0; j < window.size(); j++) {
                    char a=window.get(0);
                    if(!model.contains(a)){
                        window.remove(0);
                    }else {
                        break;
                    }
                }
                record.add(c);
                window.add(c);
                i++;
            } else if(record.size()<t.length()&&!record.contains(c)&&!window.isEmpty()){
                //匹配当前字符且包含模板里的字符  ab b
                window.add(c);
                i++;
            }else {
                //没有匹配字符
                i++;
            }
            if(record.size() == t.length()){
                //缩减窗口
                if (window.size() < size) {
                    StringBuilder builder = new StringBuilder();
                    for (int j = 0; j < window.size(); j++) {
                        builder.append(window.get(j));
                    }
                    result = builder.toString();
                    size = window.size();
                }
                //删除前缀
                Character remove = window.remove(0);
                record.remove((Object)remove);
                for (int j = 0; j < window.size(); j++) {
                    char w = window.get(0);
                    if (model.contains(w)) {
                        break;
                    } else {
                        window.remove(0);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String str1 = "ADOBECODEBANC";
//        String str2 = "BC";
//        MinWindow minWindow = new MinWindow();
//        System.out.println(minWindow.minWindow(str1, str2));

        String str1 = "AA";
        String str2 = "AA";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow1(str1, str2));
    }
}
