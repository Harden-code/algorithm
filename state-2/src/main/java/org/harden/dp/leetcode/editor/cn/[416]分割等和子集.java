//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1406 👎 0

package org.harden.dp.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-07-24 21:41:35
 */
class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
//        int[] nums={1,5,11,5};
        int[] nums = {9, 5};
        solution.canPartition(nums);
    }

    public static void print(boolean[][] target) {
        for (int i = 0; i < target.length; i++) {
            System.out.println(Arrays.toString(target[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            //奇数
            if ((sum & 1) == 1 || nums.length == 1) {
                return false;
            }
            int target = sum / 2;
            Arrays.sort(nums);
            //最小元素比target大不成立
            if (nums[0] > target) {
                return false;
            }
            //只要有一种方式就true
            //i对应几种决策 j对应能装都重量
            boolean[][] dp = new boolean[nums.length][target + 1];
            //第0阶段 dp[i][j]=dp[i-1][j]+num[i]
            // target>=dp[i-1][j]+num[i]

            dp[0][0] = true;
            dp[0][nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= target; j++) {
                    //上个状态
                    if (j - nums[i] >= 0) {
                        //放 从上个状态推导下个
                        dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];
                    } else {
                        //当前状态不放
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
//            print(dp);

            return dp[nums.length - 1][target];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}