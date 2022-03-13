package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/29 22:56
 * 文件说明：
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 *
 * 输入：arr = [0,2,1,0]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            //单调递增
            if (mid == 0) {
                l = mid + 1;
            //单调递减少
            } else if (mid == arr.length - 1) {
                h = mid - 1;
                //找到峰值
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }else if(arr[mid]>arr[mid-1]){
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        return -1;
    }
}
