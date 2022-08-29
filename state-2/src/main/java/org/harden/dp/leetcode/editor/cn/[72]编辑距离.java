//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 2535 👎 0

package org.harden.dp.leetcode.editor.cn;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author junsenfu
 * @date 2022-08-16 21:20:57
 */
class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
//        String word1="horse"; String word2="ros";
        String word1 = "a";
        String word2 = "ab";
        solution.minDistance(word1, word2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1.length() == 0) {
                return word2.length();
            }
            if (word2.length() == 0) {
                return word1.length();
            }
            //dp[i][j] word1和word2代表每个状态最少操作多少次相同 比如初始值相同就会出现两种情况
            //多个1为了更好的计算，通过上个值去判断这个值 会避免出错
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            //插入一个字符dp[i][j-1]
            //删除一个字符dp[i-1][j]
            //替换一个字符dp[i-1][j-1]
            //长度为0-word2.length 需要几次变化才能相同
            for (int i = 0; i <= word2.length(); i++) {
                dp[0][i] = i;
            }
            for (int i = 0; i <= word1.length(); i++) {
                dp[i][0] = i;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    //每个状态i,j从上个状态推导而来
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        //从上个状态到这个状态的min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1])
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                    } else {
                        //i-1,j-1 上个状态不想等 i,j +1进行操作到达这个状态
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1]+ 1) , dp[i - 1][j - 1] + 1);
                    }
                }
            }


            return dp[word1.length()][word2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}