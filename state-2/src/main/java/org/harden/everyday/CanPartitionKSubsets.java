package org.harden.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.harden.everyday.LenLongestFibSubseq.print;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/20 15:12
 * 文件说明：698. 划分为k个相等的子集 </p>
 */
public class CanPartitionKSubsets {


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //不能拆开
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        //切成k个桶
        int[] bucket = new int[k];
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        //提高桶的命中率
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        //在每个桶里分割k个元素
//        return dfs(nums,bucket,target,0);
        backTrace(nums, bucket, target, 0);
        return result;
    }

    private boolean result = false;

    private void backTrace(int[] nums, int[] bucket, int target, int index) {
        if (result) return;
        if (index == nums.length) {
            for (int j : bucket) {
                if (j == target) {
                    result = true;
                }
            }
            return;
        }
        //使用桶和下标 划分开
        for (int i = 0; i < bucket.length; i++) {
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            if (bucket[i] + nums[index] > target) continue;
            bucket[i] += nums[index];
            backTrace(nums, bucket, target, index + 1);
            bucket[i] -= nums[index];
        }
    }

    /**
     * @param nums
     * @param bucket
     * @param target 桶的重量
     * @param index  nums 下标
     * @return
     */
    private boolean dfs(int[] nums, int[] bucket, int target, int index) {
        //
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            //相等就剪纸结束 就不用继续向下分
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            bucket[i] += nums[index];
            //？
            if (dfs(nums, bucket, target, index + 1)) return true;
            bucket[i] -= nums[index];

        }
        return false;
    }

    //出现重复 无法去重
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //不能拆开
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;

        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                count++;
            } else {
                break;
            }
        }

        for (int i = 0; i < nums.length - count; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            boolean[][] dp = new boolean[nums.length - count][target + 1];
            dp[i][0] = true;
            dp[i][nums[i]] = true;

            for (int j = i + 1; j < dp.length; j++) {
                //p代表重量
                for (int p = 0; p < dp[0].length; p++) {
                    //最大可达
                    if (p - nums[j] >= 0) {
                        dp[j][p] = dp[j - 1][p] || dp[j - 1][p - nums[j]];
                    } else {
                        dp[j][p] = dp[j - 1][p];
                    }
                }
            }
            if (dp[dp.length - 1][target]) count++;
        }
        //每个阶段的重量
//        int[][] dp = new int[nums.length][target + 1];
//        dp[0][0] = 1;
//        dp[0][nums[0]] = 1;
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                //放或则放
//                if (j - nums[i] >= 0 ) {
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
//
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//
////        print(dp);
        return count >= k;
    }

    
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 3, 5, 2, 1};//4
        int[] nums = {2, 2, 2, 2, 3, 4, 5};//4
        int[] nums2 = {10, 12, 1, 2, 10, 7, 5, 19, 13, 1};
        int[] num3 = {19, 11, 1, 3, 3, 1, 9, 9, 3, 1};//3
        CanPartitionKSubsets subsets = new CanPartitionKSubsets();
        subsets.canPartitionKSubsets(nums1, 4);
//        subsets.canPartitionKSubsets(num3, 3);
    }
}
