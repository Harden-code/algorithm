package org.harden.coder.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        // l 左窗口 r有窗口
        int l = 1;
        int r = 2;
        int sum = 3;
        //l<r  r<len && l<len 结束条件
        while (l<r) {
            if (sum < target) {
                r++;
                sum += r;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                int[] nums = new int[r - l + 1];
                int k=l;
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = k++;
                }
                list.add(nums);
                l++;
            }
        }

        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        int[][] continuousSequence = findContinuousSequence.findContinuousSequence(9);
        System.out.println(Arrays.toString(continuousSequence));
    }
}
