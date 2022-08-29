//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1113 👎 0

package org.harden.dp.leetcode.editor.cn;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author  junsenfu
 * @date 2022-08-01 21:51:07
 */
class HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
//        int[] nums={1,2,3};
//        int[] nums={2,3,2,1,4};
        int[] nums = {2,9,8,0};
        System.out.println(solution.rob(nums));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        //把第一和最后一个错开
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp=new int[nums.length-1][2];
        dp[0][0]=nums[0];
        dp[0][1]=0;
        for (int i =1; i < nums.length-1; i++) {
            dp[i][0]=dp[i-1][1]+nums[i];
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
        int left=Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);

        dp=new int[nums.length-1][2];
        dp[0][0]=nums[1];
        dp[0][1]=0;
        for (int i =1; i < nums.length-1; i++) {
            dp[i][0]=dp[i-1][1]+nums[i+1];
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
        int right=Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
        return Math.max(left,right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}