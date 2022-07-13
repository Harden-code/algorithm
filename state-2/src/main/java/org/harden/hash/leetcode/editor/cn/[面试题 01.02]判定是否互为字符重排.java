//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 哈希表 字符串 排序 👍 70 👎 0

package org.harden.hash.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author junsenfu
 * @date 2022-05-18 22:05:31
 */
class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
        solution.CheckPermutation("a", "ab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            Map<Character, Integer> characters = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                characters.put(s1.charAt(i), characters.getOrDefault(s1.charAt(i), 0) + 1);
            }
            for (int i = 0; i < s2.length(); i++) {
                if (characters.containsKey(s2.charAt(i))) {
                    if (characters.get(s2.charAt(i)) != null && characters.get(s2.charAt(i)) - 1 > 0) {
                        characters.put(s2.charAt(i), characters.getOrDefault(s2.charAt(i), 0) - 1);
                    } else {
                        characters.remove(s2.charAt(i));
                    }
                } else {
                    return false;
                }
            }

            return characters.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}