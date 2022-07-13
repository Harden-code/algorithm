//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1031 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author junsenfu
 * @date 2022-06-30 21:27:53
 */
class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            int[] target = new int[n];
            int j = 1;
            for (int i = 0; i < n; i++) {
                target[i] = j++;
            }
            backTrace(target, new ArrayList<>(), k);
            return result;
        }

        private void backTrace(int[] target, List<Integer> path, int k) {
            //不等于就会少一次调用
            if (k == path.size()) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < target.length; i++) {
                int value = target[i];
                if (path.contains(value)) {
                    continue;
                }
                //都进行决策 path里最后一位必须小于value在进行决策
                if (path.isEmpty() || path.get(path.size() - 1) < value) {
                    path.add(value);
                    //先进i=0 在进i=2
                    backTrace(target, path, k);
                    path.remove(path.size() - 1);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}