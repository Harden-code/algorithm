package org.harden.coder.sort;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 18:06
 * 文件说明： 数组中的逆序对
 *
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 * 。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * </p>
 */
public class ReversePairs {
    public static int reversePairs(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            int tmp=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(tmp>nums[j]){
                    result+=1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={7,5,6,4};
        System.out.println(reversePairs(arr));
    }
}
