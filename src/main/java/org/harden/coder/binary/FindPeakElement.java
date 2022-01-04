package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/29 23:11
 * 文件说明：
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，
 * 在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int height = nums.length - 1;
        //{1}
        if(height==0){
            return height;
        }
        while (low <= height) {
            int mid = low + (height - low) / 2;
            //[2,1]
            if (mid == 0) {
                if(nums[mid+1]>nums[mid]){
                    low=mid+1;

                }else {
                    return mid;
                }

            } else if (mid == nums.length - 1) {
//                [1,2]
                if(nums[mid-1]<nums[mid]){
                    return mid;
                }else {
                    height=mid-1;
                }

            } else if (nums[mid] > nums[mid -1] && nums[mid +1] < nums[mid]) {
                return mid;
            }else if(nums[mid]<nums[mid-1]){
                //单调递增 只取右边
                height=mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
//        int[] a={1,2,1,3,5,6,4};
        int[] a={2,1};
//        int[] a={1,2};
//        int[] a={1,2,3,1};
        System.out.println(findPeakElement.findPeakElement(a));
    }
}
