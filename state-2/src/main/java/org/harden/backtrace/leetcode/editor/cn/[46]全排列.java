//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2090 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  junsenfu
 * @date 2022-07-02 16:16:28
 */
class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrace(nums,new ArrayList<>(),0);
        return result;
    }

    private void backTrace(int[] nums,List<Integer> path,int k){
        if(k==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int value=nums[i];
            if(path.contains(value)){
                continue;
            }
            path.add(value);
            backTrace(nums,path,k+1);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}