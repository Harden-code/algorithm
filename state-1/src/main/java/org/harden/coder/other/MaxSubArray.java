package org.harden.coder.other;

import org.harden.coder.dp.Print;

import java.util.Arrays;

/**
 * 53. 最大子数组和
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArray {

    public int dp(int[] nums) {
       int[] dp=new int[nums.length];
       dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if(result<dp[i]){
                result=dp[i];
            }
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < left.length; i++) {
            if (i - 1 >= 0) {
                left[i] = left[i - 1] + nums[i];
            } else {
                left[i] = nums[i];
            }
        }
        System.out.println(Arrays.toString(left));
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 < nums.length) {
                right[i] = right[i + 1] + nums[i];
            } else {
                right[i] = nums[i];
            }
        }
        System.out.println(Arrays.toString(right));
        int sum = Integer.MIN_VALUE;

        return left[nums.length - 1];
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(maxSubArray.maxSubArray(nums));
        maxSubArray.dp(nums);
    }
}
