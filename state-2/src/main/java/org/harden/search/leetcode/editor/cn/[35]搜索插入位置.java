//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1529 👎 0

package org.harden.search.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-05-09 21:50:56
 */
class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int low = 0;
            int height = nums.length - 1;
            while (low <= height) {
                int mid = low + (height - low) / 2;
                if (nums[mid] >= target) {
                    //找比target大的第一位元素
                    if (mid - 1 >= 0 && nums[mid - 1] < target) {
                        return mid;
                    } else {
                        height = mid - 1;
                    }
                } else {
                    //value<target
                    low = mid + 1;
                }

            }
            //未找到
            return height + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}