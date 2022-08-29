//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 986 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author junsenfu
 * @date 2022-08-24 21:33:41
 */
class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        String s = "abab";
        String p = "ab";
        solution.findAnagrams(s, p);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            Map<Character, Integer> hash = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                hash.put(c, hash.getOrDefault(c, 0) + 1);
            }
            int l = 0;
            int r = 0;
            Map<Character, Integer> map = new HashMap<>();

            while (l < s.length() && r < s.length()) {
                char c = s.charAt(r);
                //包含p
                if (hash.containsKey(c)) {
                    if (!map.containsKey(c) || map.getOrDefault(c, 0) < hash.get(c)) {
                        map.put(c, map.getOrDefault(c, 0) + 1);
                        if (same(hash, map)) {
                            //不应该全清退出左边
                            result.add(l);
                            char del = s.charAt(l);
                            map.put(del, map.getOrDefault(del, 0) - 1);
                            //删除一位
                            l++;
                        }
                        r++;
                    } else {
                        while (l < r) {
                            char del = s.charAt(l);
                            map.put(del, map.getOrDefault(del, 0) - 1);
                            l++;
                            if (del == c) {
                                break;
                            }
                        }
                    }
                } else {
                    //不属于p的直接清空
                    r++;
                    l = r;
                    map.clear();
                }
//                else if (!hash.containsKey(c) && map.isEmpty()) {
//                    //不在里面
//                    l++;
//                    r++;
//                } else {
//                    //删元素 从l->r
//                    while (l < r) {
//                        char del = s.charAt(l);
//                        map.put(del, map.getOrDefault(del, 0) - 1);
//                        l++;
//                        if(del==c){
//                            break;
//                        }
//                    }
//                }
            }

            return result;
        }

        private boolean same(Map<Character, Integer> map1, Map<Character, Integer> map2) {
            if (map1.size() != map2.size()) {
                return false;
            }
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                Character key = entry.getKey();
                int value = entry.getValue();
                if (map2.get(key) != value) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}