//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 2063 👎 0

package org.harden.dp.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-07-30 16:07:43
 */
class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] nums = {1, 2, 5};
//        int[] nums = {2, 5, 10, 1};
//        int[] nums = {1, 2};
        solution.coinChange(nums, 11);
//        int[] nums = {186, 419, 83, 408};
//        solution.coinChange(nums, 6249);
//        int[] nums={1,2};
//        solution.coinChange(nums,2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //背包问题
        public int coinChange_(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            //dp[i][j] 代表最小个数
            int[][] dp = new int[coins.length][amount + 1];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            //每个阶段相同的能装几个
            for (int i = 0; i <= amount / coins[0]; i++) {
                if (i * coins[0] <= amount) {
                    dp[0][i * coins[0]] = i;
                }

            }
            //决策阶段 dp[i][j]=min(dp[i][j],dp[i-1][amount-k*[coins[i]])
            for (int i = 1; i < coins.length; i++) {
                //每个阶段决策的状态 =>每个阶段装几个
                int count = amount / coins[i];
                for (int k = 0; k <= count; k++) {
                    for (int j = 0; j <= amount; j++) {
                        //dp[i - 1][j - k * coins[i]] != 0 前个阶段不可达
                        //可以连放的问题 上个阶段每状态都进行连了判断
                        if (j - k * coins[i] >= 0 && dp[i - 1][j - k * coins[i]] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i]] + k);
                        }
                    }
                }
            }
//            print(dp);
            return dp[coins.length - 1][amount] != Integer.MAX_VALUE ? dp[coins.length - 1][amount] : -1;
        }

        //爬楼梯问题
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            //最少放几个
            //dp[i]表示到达这个阶段有几种
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int i = 0; i < coins.length; i++) {
                int value = coins[i];
                //直接匹配
                if(value==amount){
                    return 1;
                }
                //大于过滤
                if(value<amount){
                    dp[value] = 1;
                }
            }
//            System.out.println(Arrays.toString(dp));
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                        //这个阶段到达=coins[]里的上个阶段
                        //dp[i]=min(dp[i-a]+[i-b])+1
                        //上阶段coins一把都进行了遍历
                        dp[i] = Math.min(dp[i - coins[j]]+1, dp[i]) ;
                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
            return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}