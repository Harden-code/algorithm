//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 2105 👎 0

package org.harden.other.leetcode.editor.cn;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author junsenfu
 * @date 2022-08-30 23:13:35
 */
class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String s = "aaflslflsldkalskaaa";
//        String t = "aaa";
        String s = "bbbAB";
        String t = "BbAb";
        //"acbbaca" "aba"
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int left = 0, right = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int count = Integer.MAX_VALUE;
            String result = "";
            Map<Character, Integer> path = new HashMap<>();
            while (left < s.length() && right < s.length()) {
                char c = s.charAt(right);
                //map里包含c的
                if (map.containsKey(c)) {
                    //存在
                    // 头不能有重复到 中间可以有重复到
                    char head = s.charAt(left);
                    if (path.getOrDefault(c, 0) < map.get(c) || head != c) {
                        path.put(c, path.getOrDefault(c, 0) + 1);
                        if (same(map, path)) {
                            if (count(path) < count) {
                                count = Math.min(count(path), count);
                                int l = left;
                                StringBuilder builder = new StringBuilder();
                                while (l <= right) {
                                    builder.append(s.charAt(l));
                                    l++;
                                }
                                result = builder.toString();
                            }
                            //删除第一个
                            char del = s.charAt(left);
                            while (left < right) {
                                if (s.charAt(left) != del) {
                                    break;
                                }
                                //如果删除的第一个重复情况，只能删除一个
                                if (map.containsKey(s.charAt(left))) {
                                    int i = map.get(s.charAt(left));
                                    int j = path.get(s.charAt(left));
                                    if (i > j) {
                                        break;
                                    }
                                }
                                path.put(del, path.getOrDefault(del, 0) - 1);
                                left++;
                            }
                            //删除多余
                            while (left < right) {
                                del = s.charAt(left);
                                if (map.containsKey(s.charAt(left))) {
                                    int i = map.get(s.charAt(left));
                                    int j = path.get(s.charAt(left));
                                    if (i >= j) {
                                        break;
                                    }

                                }
                                path.put(del, path.getOrDefault(del, 0) - 1);
                                left++;
                            }

                        }
                        right++;
                    } else {
                        //存在path里有多余情况 删除第一个
                        char del = s.charAt(left);
                        while (left < right) {
                            if (s.charAt(left) != del) {
                                break;
                            }
                            //如果删除的第一个重复情况，只能删除一个
                            if (map.containsKey(s.charAt(left))) {
                                int i = map.get(s.charAt(left));
                                int j = path.get(s.charAt(left));
                                if (i > j) {
                                    break;
                                }
                            }
                            path.put(del, path.getOrDefault(del, 0) - 1);
                            left++;
                        }
                        while (left < right) {
                            del = s.charAt(left);
                            if (map.containsKey(s.charAt(left))) {
                                int i = map.get(s.charAt(left));
                                int j = path.get(s.charAt(left));
                                if (i >= j) {
                                    break;
                                }
                            }
                            path.put(del, path.getOrDefault(del, 0) - 1);
                            left++;
                        }
                    }

                } else if (!path.isEmpty()) {
                    //不包含且里面有值直接加
                    path.put(c, path.getOrDefault(c, 0) + 1);
                    right++;
                } else {
                    right++;
                    left = right;
                }
            }
            return result;
        }


        private int count(Map<Character, Integer> map) {
            int count = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                count += entry.getValue();
            }
            return count;
        }

        private boolean same(Map<Character, Integer> map1, Map<Character, Integer> map2) {

            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                Character key = entry.getKey();
                int value = entry.getValue();
                if (map2.containsKey(key) && map2.get(key) < value) {
                    return false;
                }
                if (!map2.containsKey(key)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}