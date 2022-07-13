//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 183 👎 0

package org.harden.sort.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-04-30 15:29:08
 */
class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        int[] nums={1,3,5,7,2,4,6,8};
        solution.smallestK(nums,4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            if (arr.length < k) {
                return new int[0];
            }
            int[] result = new int[k];
            findSmall(arr, 0, arr.length - 1);
            for (int i = 0; i < result.length; i++) {
                 result[i]=arr[i];
            }
            return result;
        }

        private void findSmall(int[] arr, int l, int r) {
            if (l > r) {
                return;
            }
            int p = position(arr, l, r);
            findSmall(arr,l,p-1);
            findSmall(arr,p+1,r);
        }

        private int position(int[] arr, int l, int r) {
            int i = l;
            int k = l - 1;
            while (i < r) {
                if (arr[i] < arr[r]) {
                    swap(arr, i, k + 1);
                    k++;
                }
                i++;
            }
            swap(arr, i, k + 1);
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