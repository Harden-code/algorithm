package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/28 20:48
 * 文件说明：
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  
 * ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class Search {
    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = j + (i - j) / 2;
            //防止溢出
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={-1,0,3,5,9,12};
        search(a,2);
    }
}
