//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 双指针 计数 排序 👍 40 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  junsenfu
 * @date 2022-08-22 21:23:00
 */
class PairsWithSumLcci{
    public static void main(String[] args) {
        Solution solution = new PairsWithSumLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        //= 重合
        while (i<j){
            int sum=nums[i]+nums[j];
            if(sum==target){
                List<Integer> list=Arrays.asList(nums[i],nums[j]);
                result.add(list);
                i++;
                j--;
            }else if (sum>target){
                j--;
            }else {
                //sum<target
                i++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}