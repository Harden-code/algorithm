package org.harden.coder.binary;

import sun.security.provider.MD2;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/28 22:18
 * 文件说明：
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
                //当target为最大
                if (mid == nums.length - 1) {
                    return nums.length;
                }
                //中间情况
                if (nums[mid + 1] > target) {
                    return mid + 1;
                }
            } else {
                height = mid - 1;
                //当target为最小
                if (nums[0] > target) {
                    return 0;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsert.searchInsert(a, 2));
    }
}
