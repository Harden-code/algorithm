package org.harden.coder.dp;


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
        if(nums.length==1){
            return false;
        }
        int asInt = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        //奇数直接返回
        if (asInt % 2 != 0) return false;
        int k=asInt / 2;
        //每个阶段代表放入物品的总数
        boolean[][] dp = new boolean[nums.length][ k+ 1];
        Arrays.sort(nums);
        dp[0][nums[0]] = true;
        dp[0][0] = true;
        //i个阶段
        for(int i=1;i<nums.length;i++){
            //i个阶段的j为可达状态
            for(int j=0;j<=asInt/2;j++){
                //上个阶段推倒过来dp[i-1][j]不装 dp[i-1][j-nums[i]] 代表装入j-nums[i]这阶段的如逆推
                if(dp[i-1][j]||(j-nums[i]>=0&&dp[i-1][j-nums[i]])){
                    dp[i][j]=true;
                }
            }
        }
        return dp[nums.length-1][k];
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
        int[] nums2 = {14, 9, 8, 4, 3, 2};
        int[] nums3 = {3, 3, 3, 4, 5};
        int[] n={100};
        System.out.println(canPartition.canPartition(n));
    }
}
