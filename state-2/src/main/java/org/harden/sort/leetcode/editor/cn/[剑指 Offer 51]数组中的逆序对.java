//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 724 👎 0

package org.harden.sort.leetcode.editor.cn;

import org.harden.sort.example.QuickSort;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-04-30 15:53:18
 */
class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        int[] nums = {2,4,3,5,1};
        solution.reversePairs(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int result = 0;

        //前面一个数字大于后面的数字
        public int reversePairs(int[] nums) {
            mergerSort(nums, 0, nums.length - 1);
            return result;
        }

        //归并合并阶段 如果左数组当前节点大于右数组当前节点，则就是当前节点的逆序度
        public void mergerSort(int[] nums, int l, int r) {
            //
            if (l >= r) return;
            int p = l + (r - l) / 2;
            mergerSort(nums, l, p);
            mergerSort(nums, p + 1, r);
            merger(nums, l, p, r);
        }

        public void merger(int[] nums, int l, int p, int r) {
            int i = l;
            int j = p+1;
            int[] temp = new int[r - l + 1];
            int k = 0;
            // =不能漏
            while (i <= p && j <= r) {
                if (nums[i] >nums[j]) {
                    //3,5,7   2,4,6
                    //   i    p      左右两边的都是有序的
                    //
                    int count = p - i + 1;
                    result += count;
                    temp[k++] = nums[j];
                    j++;
                } else {
                    temp[k++] = nums[i];
                    i++;
                }
            }
            while (i <= p) {
                temp[k++] = nums[i];
                i++;
            }
            while (j <= r) {
                temp[k++] = nums[j];
                j++;
            }
            //注意下标
            for (int t = 0; t <=r-l; t++) {
                nums[l+t] = temp[t];
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}