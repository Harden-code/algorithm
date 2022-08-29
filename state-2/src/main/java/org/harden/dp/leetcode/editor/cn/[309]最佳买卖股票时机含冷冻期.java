//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1281 👎 0

package org.harden.dp.leetcode.editor.cn;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author  junsenfu
 * @date 2022-08-02 23:24:56
 */
class BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        int[] nums={1,2,3,0,2};
        solution.maxProfit(nums);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        // 0 买 1 冷冻期 2 卖
        int[][] dp=new int[prices.length][3];
        //买
        dp[0][0]=-prices[0];
        //搞清楚每个环节之前的状态 没个状态都当前环节的最优
        for (int i = 1; i < prices.length; i++) {
            //买 1 上环节冷冻期+这环节买  2 上缓解买
            dp[i][0]=Math.max(dp[i-1][1]-prices[i],dp[i-1][0]);
            //冷 1 上环节卖 2 上环节冷冻期
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]);
            //卖 1 上环节卖 2 这环节卖
            dp[i][2]=Math.max(dp[i-1][2],prices[i]+dp[i-1][0]);
        }
//        print(dp);
        return dp[prices.length-1][2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}