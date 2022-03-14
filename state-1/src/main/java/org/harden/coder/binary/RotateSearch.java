package org.harden.coder.binary;



/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/29 21:34
 * 文件说明：
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class RotateSearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= nums[height]) {
                //右边有序 确保target在右边区间
                if (nums[mid] < target && nums[height] >= target) {
                    low = mid + 1;
                } else {
                    height = mid-1;
                }
            }else {
                //左边有序  确保target在右区间
                if (nums[low] <= target && nums[mid] >= target) {
                    height = mid-1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotateSearch rotateSearch = new RotateSearch();
//        int[] a={4,5,6,7,0,1,2};
//        int[] a={3,5,1};
//        int[] a={4,5,6,7,8,1,2,3};
        int[] a={4,5,6,7,0,1,2};
        System.out.println(rotateSearch.search(a, 5));
    }
}
