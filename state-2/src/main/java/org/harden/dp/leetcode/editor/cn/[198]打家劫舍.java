//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 2233 👎 0

package org.harden.dp.leetcode.editor.cn;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author  junsenfu
 * @date 2022-08-01 21:29:11
 */
class HouseRobber{
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        int[] nums={2,7,9,3,1};
        solution.rob(nums);
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        //两个状态 偷0 下个不能偷 或者不偷1下个能偷

        //dp[i][0]=dp[i-1][1]+value 偷只能从上个状态不偷转
        //dp[i][1]=max(dp[i-1][0],dp[i-1][1]) 不偷从上个状态偷和不偷之间转
        int[][] dp=new int[nums.length][2];
        dp[0][0]=nums[0];
        dp[0][1]=0;
        for (int i = 1; i < nums.length; i++) {
            //不偷转
//            dp[i][0]=Math.max(dp[i-1][1]+nums[i],dp[i-1][0]); 重复检验了
            dp[i][0]=dp[i-1][1]+nums[i];
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
//        print(dp);
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}