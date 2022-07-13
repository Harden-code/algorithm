//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1186 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-07-06 21:30:09
 */
class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> partition(String s) {
            backTrace(s, new ArrayList<>(), 0);
            return result;
        }

        private void backTrace(String str, List<String> path, int begin) {
            if (begin >= str.length()) {
                if (begin == str.length()) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            //决策切几个
            for (int i = 1; i <= str.length(); i++) {
                //aa b 2 2溢出
                if (begin + i > str.length()) {
                    return;
                }
                //begin 初始位置 0 - 1  1 - 1
                //             0 - 2  2 - 2
                String substring = str.substring(begin, begin + i);
                if (is(substring.toCharArray())) {
                    path.add(substring);
                    backTrace(str, path,  begin + i);
                    path.remove(path.size() - 1);
                }
            }

//        int i=k;
//        while (i<str.length()){
//            String substring = str.substring(i, i + k);
//            if(is(substring.toCharArray())){
//                path.add(substring);
//                backTrace(str,path,i+k,k+1);
//                path.remove(path.size()-1);
//            }
//            i+=k;
//        }

        }

        private boolean is(char[] chars) {
            int i = 0;
            int j = chars.length - 1;
            while (i <= j) {
                if (chars[i] == chars[j]) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}