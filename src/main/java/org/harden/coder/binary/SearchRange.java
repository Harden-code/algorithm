package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/28 22:44
 * 文件说明：
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    int l = mid;
                    //相等会多一次
                    while (l < nums.length && nums[l] == target) {
                        l++;
                    }
                    return new int[]{mid, l-1};
                } else {
                    //=target 情况
                    height = mid -1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                height = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] a = {5,7,7,8,8,10};
        searchRange.searchRange(a, 8);
    }
}
