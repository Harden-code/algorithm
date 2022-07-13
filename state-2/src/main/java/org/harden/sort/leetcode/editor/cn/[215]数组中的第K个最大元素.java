//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1637 👎 0

package org.harden.sort.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-04-30 14:21:43
 */
class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
//        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums={1};
        System.out.println(solution.findKthLargest(nums, 1));
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //利用快排的思想进行优化
        //选取中间点
        //case 1 当中间点 p-q+1=k 就说明找到
        //case 2 当中间点 p-q+1>k 在左边 否则在右边 q-q+1-k=
        public int findKthLargest(int[] nums, int k) {
            //
            if (nums.length  < k) return -1;
            return find(nums, 0, nums.length - 1, k);
        }

        public int find(int[] nums, int p, int q, int k) {
            if (p > q) {
                return -1;
            }
            int mid = position(nums, p, q);
            if (mid - p + 1 == k) {
                return nums[mid];
            } else if (mid - p + 1 < k) {
                //-1 mid是中点 可以忽略还可以避免重复
                return find(nums, mid + 1, q, k - (mid - p + 1));

            } else {
                return find(nums, p, mid - 1, k);
            }
        }

        private int position(int[] nums, int p, int q) {
                    int i = p;
                    //记录小于nums[q]数点右区间
                    int k = p - 1;
                    while (i < q) {
                        if (nums[i] > nums[q]) {
                    swap(nums, i, k + 1);
                    k++;
                }
                i++;
            }
            swap(nums, i, k + 1);
            return k + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}