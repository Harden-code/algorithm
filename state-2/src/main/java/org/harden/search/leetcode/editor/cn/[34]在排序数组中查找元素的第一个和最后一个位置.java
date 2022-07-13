//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1670 👎 0

package org.harden.search.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-05-09 22:16:08
 */
class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
//        int[] nums={5,7,7,8,8,10};
        int[] nums = {2,2};
        int[] ints = solution.searchRange(nums, 2);
        System.out.println(Arrays.toString(ints));
//        solution.findMax(0,1,nums,1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //特殊情况
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            //找出第一个和最后一个
            int low = 0;
            int height = nums.length - 1;
            return new int[]{findMin(low, height, nums, target), findMax(low, height, nums, target)};
        }

        private int findMin(int low, int height, int[] nums, int target) {
            while (low <= height) {
                int mid = low + (height - low) / 2;
                if (nums[mid] >= target) {
                    if (nums.length == 1) {
                        return nums[mid] == target ? mid : -1;
                    }
                    //<target 如过是<=还需进行判断,这样好处省略代码
                    if (mid - 1 >= 0 && nums[mid - 1] < target) {
                        return nums[mid] == target ? mid : -1;
                    } else {
                        height = mid - 1;
                    }
                } else {
                    //value<target
                    low = mid + 1;
                }
            }
            //特殊情况 当num[0]为target时 mid-1会把0给过滤
            if (nums[0] == target) {
                return height + 1;
            }
            return -1;
        }

        private int findMax(int low, int height, int[] nums, int target) {
            while (low <= height) {
                int mid = low + (height - low) / 2;
                //先处理命中情况，再处理在左右半部分查找的情况
                if (nums[mid] == target) {
                    //前后区间探测
                    if (mid + 1<=height && nums[mid +1]==target) {
                        low = mid + 1;
                    } else {
                        return nums[mid] == target ? mid : -1;
                    }
                } else if (nums[mid] > target){
                    height = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}