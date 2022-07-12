//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 1020 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author junsenfu
 * @date 2022-07-05 22:22:08
 */
class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        solution.combinationSum2(nums, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();


        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < candidates.length; i++) {
                int value = candidates[i];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            int[] keys = new int[map.size()];
            int[] values = new int[map.size()];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
                i++;
            }
            backTrace(keys, values, target, new ArrayList<>(), 0, 0);
            return result;
        }

        //有重复只能使用一次 k来控制数组下标
        private void backTrace(int[] keys, int[] values, int target, List<Integer> path, int sum, int k) {
            if (k == keys.length || sum >= target) {
                if (sum == target) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            //转换成不同值加几个 通过元素存在个数在进行决策
            for (int i = k; i <keys.length; i++) {
                //跳过查下阶段
                if(values[i]==0){
                    continue;
                }
                values[i]--;
                path.add(keys[i]);
                backTrace(keys,values,target,path,sum+keys[i],i);
                values[i]++;
                path.remove(path.size()-1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}