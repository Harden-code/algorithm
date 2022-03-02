package org.harden.coder.dp;

import sun.security.pkcs11.Secmod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/21 21:06
 * 文件说明： 416. 分割等和子集</p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {
    private boolean result;

    //0-1 背包问题，挑选一些数出来，作为数组和的一半
    public boolean canPartition(int[] nums) {
        int max = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (max % 2 != 0) {
            return false;
        }
        int target = max / 2;
        //dp[i][j]=dp[i-1][j] || dp[i-1][target-dp[i - 1][j]]+num[i] 每个阶段,放入或者不放入
        int[][] dp = new int[nums.length][target+1];
        dp[0][0] = 0;
        dp[0][nums[0]] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //dp[i-1][j]>0在上一个放的基础上做抉择
                if (dp[i - 1][j] > 0 && target - dp[i - 1][j] >= 0) {
                    dp[i][j] = dp[i - 1][j];
                    dp[i][target - dp[i - 1][j]] = dp[i - 1][j] + nums[i];
                    if(dp[i][j]== target||dp[i][target - dp[i - 1][j]]==target){
                        return true;
                    }
                }
            }
        }
        print(dp);
        return false;
    }

    private void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }


    public boolean canPartition1(int[] nums) {
        int max = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (max % 2 != 0) {
            return false;
        }
        backTrace(nums, max / 2, 0, new ArrayList<>());
        return result;
    }

    public void backTrace(int[] nums, int max, int k, List<Integer> list) {
        if (nums.length == k) {
            list.stream().reduce(Integer::sum).ifPresent(e -> {
                if (e.intValue() == max) {
                    result = true;
                }
            });

            return;
        }
        backTrace(nums, max, k + 1, list);
        //放入背包
        list.add(nums[k]);
        backTrace(nums, max, k + 1, list);
        list.remove(list.size() - 1);
    }





    public boolean rs(int max, int i, int[] nums, int len) {
        if (i == len) {
            if (max == 0) {
                return true;
            } else {
                return false;
            }
        }
        return rs(max - nums[i], i + 1, nums, len);
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        int[] nums = {1, 2, 3, 5};
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2={14,9,8,4,3,2};
        int[] nums3={3,3,3,4,5};
        System.out.println(canPartition.canPartition(nums2));
    }
}
