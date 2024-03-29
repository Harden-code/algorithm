package org.harden.coder.dp;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/27 18:09
 * 文件说明： 198. 打家劫舍</p>
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            //偷
            //前一个不偷dp[i-1][0]+num[i],前一个偷dp[i-1][0]
            dp[i][0]=Math.max(dp[i-1][1]+nums[i],dp[i-1][0]);
            //不偷
            //前一个头dp[i-1][1] 前一个偷dp[i-1][]0
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]);
        }


        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
//        [2,1,1,2]
        int[] nums={2,1,1,2};
        System.out.println(rob.rob(nums));
    }
}
