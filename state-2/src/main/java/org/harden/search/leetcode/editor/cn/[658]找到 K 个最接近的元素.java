//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 319 👎 0

package org.harden.search.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-05-12 21:41:16
 */
class FindKClosestElements {
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
//        int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        solution.findClosestElements(arr, 4, 3).forEach(System.out::println);
//        int[] arr = {1, 1, 1, 10, 10, 10};
//        solution.findClosestElements(arr, 1, 9).forEach(System.out::println);
//        int[] arr={0,0,0,1,3,5,6,7,8,8};
//        solution.findClosestElements(arr,2,2).forEach(System.out::println);
        int[] arr = {0, 1, 2, 2, 2, 3, 6, 8, 8, 9};
        solution.findClosestElements(arr, 5, 9).forEach(System.out::println);
//        int[] arr={1,3};
//        solution.findClosestElements(arr,1,2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] arr, int k, int x) {
            int low = 0;
//            int height = arr.length - k - 1;
            int height = arr.length - 1;
            while (low <= height) {
                int mid = low + (height - low) / 2;
                //找到等于x或者比x大最小的
                if (arr[mid] >= x) {
                    if (mid == 0 || arr[mid - 1] < x) {
                        return mid;
                    } else {
                        height = mid - 1;
                    }
                } else {
                    //x>arr[mid]
                    low = mid + 1;
                }

            }
//            return arr.length - k - 1;
            return arr.length - 1;
        }

        //输入：arr = [1,2,3,4,5], k = 4, x = 3
        //输出：[1,2,3,4]
        //最靠近 x（两数之差最小）的 k 个数
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> result = new ArrayList<>();
            //先找到最贴近与x元素的位置 比x大的最小的元素
            int mid = findMin(arr, k, x);
            //在用双指针确认区间
            int left = Math.max(mid - k, 0);
            int right = Math.min(mid + k, arr.length - 1);
            while (right - left >= k) {
                int i = x - arr[left];
                int j = arr[right] - x;
                if (i <= j) {
                    right--;
                }
                if (i > j) {
                    left++;
                }
            }
            int len = left + k;
            for (; left < len; left++) {
                result.add(arr[left]);
            }
            return result;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


