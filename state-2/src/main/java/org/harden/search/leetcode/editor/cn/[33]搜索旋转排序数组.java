//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 👍 2073 👎 0

package org.harden.search.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-05-11 21:38:13
 */
class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {5,1,3};
        int[] nums = {3, 1};
//        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};

        System.out.println(solution.search(nums, 1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            //通过查找左右 有序区间 ，再在区间里查找
            int low = 0;
            int height = nums.length - 1;
            while (low <= height) {
                int mid = low + (height - low) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] >= nums[low]) {
                    //左边有序 再判断target是否在有序区间
                    if (nums[mid] >= target && nums[low] <= target) {
                        //左移动
                        height = mid - 1;
                    } else {
                        //不在区间内 向右移动
                        low = mid + 1;
                    }
                } else {
                    //右边有序
                    if (nums[height] >= target && nums[mid] <= target) {
                        //右移动
                        low = mid + 1;
                    } else {
                        height = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}