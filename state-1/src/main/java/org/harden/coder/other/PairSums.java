package org.harden.coder.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.24. 数对和
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 */
public class PairSums {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //先进行排序,下表才可以移动
        Arrays.sort(nums);
        int begin = 0;
        int last = nums.length - 1;
        while (begin < last) {
            int source = nums[begin] + nums[last];
            if (source == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[begin]);
                list.add(nums[last]);
                result.add(list);
                begin++;
                last--;
            } else if (source > target) {
                //大于向左移动
                last--;
            } else {
                //小于
                begin++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PairSums pairSums = new PairSums();
        int[] nums={5,6,5,6};
        pairSums.pairSums(nums,11);
    }
}
