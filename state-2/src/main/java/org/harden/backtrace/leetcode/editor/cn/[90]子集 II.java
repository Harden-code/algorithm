//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
//
//
//
// Related Topics 位运算 数组 回溯 👍 867 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.*;

/**
 * @author junsenfu
 * @date 2022-06-30 22:24:45
 */
class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        int[] nums = {1, 2, 2};
        solution.subsetsWithDup(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
//            Arrays.sort(nums);
//            backTraceLow(nums,new ArrayList<>(),0);
            //转换成多阶段模型 map key-数值 value-个数
            //转换成每个阶段对应的key 放或不放放几个
            Map<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            }
            int[] keys = new int[count.size()];
            int[] values = new int[count.size()];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
                i++;
            }
            backTrace(keys, values, new ArrayList<>(), 0);
            return result;
        }

        private void backTrace(int[] keys, int[] values, List<Integer> path, int k) {
            if (k == keys.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            //根据不同元素个数做决策=>完全背包问题
            //比如 1,2,2 1-2 2-2
            //有每个阶段决策 1 > 0,1 ,2 >0,1,2
            for(int count=0;count<=values[k];count++){
                //等于就多计算一次 1 > 0,1 ,2 >0,1,2
                for(int i=0;i<count;i++){
                    path.add(keys[k]);
                }
                backTrace(keys, values, path, k + 1);
                for(int i=0;i<count;i++){
                    path.remove(path.size()-1);
                }
            }




        }

        private void backTraceLow(int[] nums, List<Integer> path, int k) {
            if (k == nums.length) {
                if (is(path)) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            backTraceLow(nums, path, k + 1);
            path.add(nums[k]);
            backTraceLow(nums, path, k + 1);
            path.remove(path.size() - 1);
        }

        private boolean is(List<Integer> list) {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).equals(list)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}