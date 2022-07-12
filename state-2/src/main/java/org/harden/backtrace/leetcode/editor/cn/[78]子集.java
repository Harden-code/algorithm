//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1691 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author  junsenfu
 * @date 2022-06-30 22:15:05
 */
class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,new ArrayList<>(),0);
        return result;
    }

    private void backTrace(int[] nums,List<Integer> path,int k){
        if(nums.length==k){
            if(result.isEmpty())
            result.add(new ArrayList<>(path));
            return;
        }
        //两种情况 装或不装
        backTrace(nums,path,k+1);
        //装
        path.add(nums[k]);
        backTrace(nums,path,k+1);
        path.remove(path.size()-1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}