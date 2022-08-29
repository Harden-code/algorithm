//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
// Related Topics 数组 动态规划 👍 892 👎 0

package org.harden.dp.leetcode.editor.cn;



import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author junsenfu
 * @date 2022-07-30 19:00:09
 */
class CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        int[] nums = {1, 2, 5};
        solution.change(5, nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            //每个状态代表 这个状态有几种方法
            int[][] dp = new int[coins.length][amount + 1];
            for (int i = 0; i <= amount / coins[0]; i++) {
                dp[0][i * coins[0]] = 1;
            }
            for (int i = 1; i < coins.length; i++) {
                int count = amount / coins[i];
                for (int k = 0; k <= count; k++) {
                    for (int j = 0; j <= amount; j++) {
                        //由上个状态推导
                        if (j - k * coins[i] >= 0 && dp[i - 1][j - k * coins[i]] > 0) {
                            dp[i][j] += dp[i - 1][j - k * coins[i]];
                        }
                    }
                }
            }
//            print(dp);
            return dp[coins.length - 1][amount];
        }

        //不能用爬楼梯问题解决，会出现重复现象 爬楼梯解决组合问题？
        //如果求最少可以求解因为他没有重复状态
        //[1,2] 3  1,1,1  2,1   2,1
        public int change_ (int amount, int[] coins) {
            //第i阶段构成方法 由前面的几个到达阶段构成
            //dp[i]=dp[i-a]+dp[i-b]
            int[] dp = new int[amount + 1];
            for (int i = 0; i < coins.length; i++) {
                int value = coins[i];

                if (value <= amount) {
                    dp[value] = 1;
                }
            }
            for (int i = 0; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {

                    if (i - coins[j] >= 0 && dp[i - coins[j]] != 0) {

                            dp[i] += dp[i - coins[j]];


                    }
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[amount] == 0 ? 0 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}