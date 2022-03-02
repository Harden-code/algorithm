package org.harden.coder.dp;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/27 22:35
 * 文件说明：213. 打家劫舍 II </p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob2 {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        /**
         * 分离成两个状态做打家劫舍 [2,3,2,1]
         * 1.当第一个偷,最后一个就不能偷
         *  [2,3,2]
         * 2.当第二偷,最后一个就可以偷
         *  [3,2,1]
         *
         *  打家劫舍问题：
         *  偷：dp[i-1][1]+nums[i],dp[i-1][0]
         *  不偷：dp[i-1][1],dp[i-1][0]
         */
        int a=dp(nums,1,nums.length-1);
        System.out.println();
        int b=dp(nums,2,nums.length);
        System.out.println("ab "+a+" "+b);
        return Math.max(a,b);
    }

    private int dp(int[] nums, int begin, int end) {
        int[][] dp = new int[nums.length][2];
        dp[begin-1][0] = nums[begin-1];
        dp[begin-1][1] = 0;
        for (int i = begin; i < end; i++) {
            dp[i][0]=Math.max(dp[i-1][1]+nums[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]);
        }
//        Print.print(dp);
        return Math.max(dp[end-1][1],dp[end-1][0]);
    }

    public static void main(String[] args) {
        Rob2 rob2 = new Rob2();
        int[] nums={1,2,3};
//        int[] nums={2,3,2};
//        int[] nums={1,2,3,1};
        rob2.rob(nums);
    }
}