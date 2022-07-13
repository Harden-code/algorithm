//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 14425 👎 0

package org.harden.hash.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  junsenfu
 * @date 2022-05-17 21:30:48
 */
class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //通过hash存储key 元素 value 位置
        Map<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i],i);
        }

        for (int i=0;i<nums.length;i++){
            int value=target-nums[i];
            if(hash.containsKey(value)){
                Integer integer = hash.get(value);
                if(i>=integer){
                    continue;
                }
                return new int[]{i,integer};
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}