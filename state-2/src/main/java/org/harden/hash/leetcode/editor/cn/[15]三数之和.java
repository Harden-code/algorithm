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
// Related Topics 数组 双指针 排序 👍 4779 👎 0

package org.harden.hash.leetcode.editor.cn;

import java.util.*;

/**
 * @author junsenfu
 * @date 2022-05-17 21:39:23
 */
class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums={0,0,0,0};
        int[] nums = {-2, 0, 1, 1, 2};
        solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //先排个序 可以避免元素重复
            Arrays.sort(nums);
            //[-1,0,1,2,-1,-4]=>[-4,-1,-1,0,1,2] hash只存储最后一个
            Map<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hash.put(nums[i], i);
            }
            //a+b=c
            for (int i = 0; i < nums.length; i++) {
                if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int sum = -1 * nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    //j-1>i 去重
                    if (j - 1 > i && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int value = sum - nums[j];
                    Integer index = hash.get(value);
                    if (index != null && index > j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[hash.get(value)]);
                        result.add(list);
                    }

                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}