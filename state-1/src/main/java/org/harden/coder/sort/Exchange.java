package org.harden.coder.sort;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 15:47
 * 文件说明：调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，
 * 所有偶数在数组的后半部分。
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * </p>
 */
public class Exchange {
    public static int[] exchange(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while (i<=j){
            //奇数
            if(nums[i]%2==1){
                i++;
                continue;
            }
            //偶数
            if(nums[j]%2==0){
                j--;
                continue;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        exchange(nums);
    }
}
