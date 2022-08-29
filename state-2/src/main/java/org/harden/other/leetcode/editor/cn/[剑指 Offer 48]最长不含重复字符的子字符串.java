//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 490 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author junsenfu
 * @date 2022-08-23 23:00:23
 */
class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        String s="abcabcbb";
        solution.lengthOfLongestSubstring(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.isEmpty()){
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int l = 0;
            int r = 0;
            Set<Character> hash = new HashSet<>();
            while (l < s.length() && r < s.length()) {
                char value = s.charAt(r);
                if (!hash.contains(value)) {
                    hash.add(value);
                    r++;
                    max=Math.max(hash.size(),max);

                } else {
                    //删除
                    while (!hash.isEmpty()) {
                        if (s.charAt(l)!=value) {
                            char del = s.charAt(l);
                            hash.remove(del);
                            l++;
                        }
                        //删除到等于当前元素
                        if(s.charAt(l)==value){
                            char del = s.charAt(l);
                            hash.remove(del);
                            l++;
                            break;
                        }

                    }

                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}