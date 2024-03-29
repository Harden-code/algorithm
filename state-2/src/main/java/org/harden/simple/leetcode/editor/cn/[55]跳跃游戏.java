//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1726 👎 0

package org.harden.simple.leetcode.editor.cn;


/**
 * @author junsenfu
 * @date 2022-03-22 22:08:06
 */
class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
//        int[] nums={3,2,1,0,4};
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums={1,2,3};
        solution.canJump(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：nums = [3,2,1,0,4]
        //输出：false
        //解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
        public boolean canJump(int[] nums) {
            //第一步只能走一步  记录能走的下标
            int step = nums[0];
            //如果i+nums[i]大于之前的step,就记录下来 step表示能走下标
            for (int i = 1; i < nums.length; i++) {
                int target = i + nums[i];
                //大于就改变  i<=step 表示step还没落后于i
                if (target > step && i <= step) {
                    step = target;
                }
                if (i > step) {
                    return false;
                }
            }
            //最后如果大于nums.length就说明可以跳出去 +1前面忽略的第一步
            return step+1 >= nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}