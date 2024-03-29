package org.harden.coder.simple;

import java.util.Arrays;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/11/30 23:13
 * 文件说明： </p>
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] source =new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;i<j;j--){
                if(target==nums[i]+nums[j]){
                    source[0]=i;
                    source[1]=j;
                    return source;
                }
            }
        }
        return source;
    }

    public static void main(String[] args) {
        int[] nums= {3,2,4} ;

        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
