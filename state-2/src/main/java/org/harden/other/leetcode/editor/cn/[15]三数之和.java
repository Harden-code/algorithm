//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 5145 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author junsenfu
 * @date 2022-08-22 21:28:01
 */
class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
//        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int[] nums={-1,0,1,2,-1,-4};
        solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int i = 0;
            int j = nums.length - 1;
            Arrays.sort(nums);
//            boolean[] used = new boolean[nums.length];
            while (i < j) {
                int out = nums[i];
                int k = i + 1;
                int h = j;
                //去重 从前面减 +1就会被忽略
                if (i - 1 >= 0 && out == nums[i - 1]) {
                    i++;
                    continue;
                }
                //等于重合
                while (k < h) {
                    //去重
                    if (k - 1 > i && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    //顺序颠倒
                    if (h + 1 <= j && nums[h] == nums[h + 1]) {
                        h--;
                        continue;
                    }
                    int sum = out + nums[k] + nums[h];
                    if (sum == 0) {
                        List<Integer> list = Arrays.asList(out, nums[k], nums[h]);

                        //不能直接break -4+1+3 -4+0-4
                        k++;
                        h--;
                        result.add(list);
                    } else if (sum > 0) {
                        h--;
                    } else {
                        //sum<0
                        k++;
                    }
                }
                i++;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}