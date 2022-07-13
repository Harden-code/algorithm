//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1109 👎 0

package org.harden.backtrace.leetcode.editor.cn;



import java.util.*;

/**
 * @author junsenfu
 * @date 2022-07-02 16:24:46
 */
class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();


        public List<List<Integer>> permuteUnique(int[] nums) {
            Map<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int key = nums[i];
                hash.put(key, hash.getOrDefault(key, 0) + 1);
            }
            backTrace(hash, new ArrayList<>(), 0, nums.length);
            return result;
        }

        private void backTrace(Map<Integer, Integer> counts, List<Integer> path, int k, int all) {
            if (all == k) {
                List<Integer> temp = new ArrayList<>(path);
                result.add(temp);
                return;
            }
            Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
            //去掉递归树 每个阶层的重复
            for (Map.Entry<Integer, Integer> entry : entries) {
                int key = entry.getKey();
                int count = counts.get(key);
                if (count <= 0) {
                    continue;
                }
                path.add(key);
                counts.put(key, counts.getOrDefault(key,0)-1);
                backTrace(counts, path, k + 1, all);
                path.remove(path.size() - 1);
                counts.put(key, counts.getOrDefault(key,0)+1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}