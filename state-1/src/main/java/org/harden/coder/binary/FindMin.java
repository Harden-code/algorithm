package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/29 22:07
 * 文件说明：
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class FindMin {

    public int findMin(int[] nums) {
        int low = 0;
        int height = nums.length - 1;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if(low==height){
                return mid;
            }
            //顺序排序 //最左边最小  4,5,6,7,0,1,2
            if (mid == 0 && nums[mid] < nums[height] || mid != 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] >= nums[height]) {
                //最小在右边
                low = mid + 1;
            } else {
                height = mid - 1;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
//        int[] a={3,4,5,1,2};
//        int[] a= {4,5,6,7,0,1,2};
        int[] a = {2, 1};
//        int[] a = {3, 1, 2};
//        int[] a ={11,13,15,17};
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(a));
    }
}
