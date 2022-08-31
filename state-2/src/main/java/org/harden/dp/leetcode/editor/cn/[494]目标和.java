//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1314 👎 0

package org.harden.dp.leetcode.editor.cn;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-07-27 21:34:18
 */
class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        int target = -1000;
        int[] nums = {0,0,0,0,0,0,0,1000};
        solution.findTargetSumWays(nums, target);

    }

    public static void print(int[][] target) {
        for (int i = 0; i < target.length; i++) {
            System.out.println(Arrays.toString(target[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            //上个状态本来就到达(不用装)+上个状态装加上这个状态装装上的刚好够
            //dp[i][j]=dp[i-1][j-num[i]]+ dp[i-1][j]

            //l-r=target r+l=sum  l=(sum+target)/2

            if (nums.length == 1 && nums[0] == Math.abs(target)) {
                return 1;
            }
            if (nums.length == 1 && nums[0] < Math.abs(target)) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            //奇数就不存在
            if (((sum + target) & 1) == 1) {
                return 0;
            }
            int value = (sum + target) / 2;
            

            int len = nums.length;
            //到达某个状态有几种方法
            int[][] dp = new int[len][value + 1];
            dp[0][0] = 1;
            //两个状态相同
            if (nums[0] == 0) {
                dp[0][nums[0]] = 2;
            } else {
                dp[0][nums[0]] = 1;
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= value; j++) {
                    if (j - nums[i] >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[len - 1][value];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}