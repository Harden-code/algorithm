package org.harden.coder.other;


import java.util.Arrays;

/**
 * 1. 两数之和
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            int sum=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(sum==nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums={3,2,4};
        int[] ints = twoSum.twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }
}
