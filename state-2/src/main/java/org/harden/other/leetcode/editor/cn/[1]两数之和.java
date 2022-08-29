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
// Related Topics 数组 哈希表 👍 15161 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.*;

/**
 * @author  junsenfu
 * @date 2022-08-23 21:35:45
 */
class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int p = 0; p < nums.length; p++) {
            if (map.containsKey(nums[p])) {
                List<Integer> list = map.get(nums[p]);
                list.add(p);
//                map.put(nums[i],);
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(p);
                map.put(nums[p],list);
            }
        }
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;

        while (i<j){
            int sum=nums[i]+nums[j];
            if(sum==target){
                List<Integer> list1 = map.get(nums[i]);
                List<Integer> list2 = map.get(nums[j]);
                if(list1.size()>1||list2.size()>1){
                    return new int[]{list2.get(0),list2.get(1)};
                }else {
                    return new int[]{list1.get(0),list2.get(0)};
                }

            }else if(sum>target){
                j--;
            }else {
                i++;
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}