//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
// Related Topics 字符串 动态规划 👍 1082 👎 0

package org.harden.dp.leetcode.editor.cn;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author junsenfu
 * @date 2022-08-14 21:16:40
 */
class LongestCommonSubsequence {

    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
//        String m1 = "bsbininm";
//        String m2 = "jmjkbkjkv";
//        String  m1 = "abcde";String m2 =  "ace";

       String m1 ="psnw";
       String m2 ="vozsh";

//        String m1="bl";String m2= "yby";
//        String m1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String m2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        solution.longestCommonSubsequence(m1, m2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public   int i;

        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text2.length() ][text1.length()];
            //有三种状态
            // dp[n-1][m-1] n m 同时增加或删除
            // dp[n-1][m] n 增加或删除 m不动
            // dp[n][m-1] n不动 m 增加或删除
            boolean flag = false;
            for (int i = 0; i < dp[0].length; i++) {
                if (text2.charAt(0) == text1.charAt(i)||flag) {
                    dp[0][i] = 1;
                    flag=true;
                }
            }
            flag = false;
            for (int i = 0; i < dp.length; i++) {
                if (text1.charAt(0) == text2.charAt(i)||flag ) {
                    dp[i][0] = 1;
                    flag=true;
                }
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    //
                    if (text2.charAt(i) == text1.charAt(j)) {
                        //相同才加1
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]+1);
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
            }
//            print(dp);

            return dp[text2.length() - 1][text1.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}