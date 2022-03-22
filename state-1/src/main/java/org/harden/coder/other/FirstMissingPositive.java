package org.harden.coder.other;

/**
 * 41. 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 */
public class FirstMissingPositive {
    /**
     * 思路：[1,2,0]=>[0,1,2]
     * [3,4,-1,1]=>[1,-1,3,4]
     * 在nums数组的数可以跟
     * 数组下表一一对应上：下表0的放1 下标1的放2
     * 找到第一个不符合对应下标的nums[i] i+1就是最小正整数
     *
     * 把nums里的元素映射到nums对应的下标+1
     */

    public int firstMissingPositive(int[] nums) {

        int result = 0;
        int max = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //while循环 确保被交换nums[i]的也被交换  （nums[nums[i] - 1] != nums[i]=> 1,1去重 两个下标里的元素都相同）
            while (nums[i]-1 >= 0 && nums[i] - 1 < max && nums[nums[i] - 1] != nums[i]) {
                //使用的下标进行交换
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result= i + 1;
                return result;
            }
        }
        //没有匹配
        return max+1;
    }

    public void swap(int[] nums, int target, int source) {
        int temp = nums[target];
        nums[target] = nums[source];
        nums[source] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {7, 8, 9, 11, 12};
//        int[] nums = {0,1,2};
//        int[] nums = {1,1};
        int[] nums = {3,4,-1,1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }
}
