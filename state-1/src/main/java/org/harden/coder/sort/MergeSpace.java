package org.harden.coder.sort;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 15:57
 * 文件说明：
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class MergeSpace {
    public int[][] merge(int[][] intervals) {
        sort(intervals);

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (stack.isEmpty()) {
                stack.push(interval);
                continue;
            }
            if (!stack.isEmpty() && is(stack, interval)) {
                int[] pop = stack.pop();
                int[] ints = new int[2];
                ints[0] = pop[0];
                if(pop[1]>interval[1]){
                    ints[1] = pop[1];
                }else {
                    ints[1] = interval[1];
                }

                stack.push(ints);
            } else {
                stack.push(interval);
            }
        }
        int[][] temp = new int[stack.size()][2];
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = stack.pop();
        }
        return temp;
    }

    public void sort(int[][] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i][0];
            int[] tmp=nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(nums[j][0]>value){
                    nums[j+1]=nums[j];
                }else {
                    break;
                }
            }
            nums[j+1]=tmp;
        }
    }

    public boolean is(Stack<int[]> stack, int[] tmp) {
        int[] peek = stack.peek();
        if (peek[1] >= tmp[0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MergeSpace mergeSpace = new MergeSpace();
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] a={{1,4},{0,4}};
        int[][] merge = mergeSpace.merge(a);
        System.out.println(merge);
    }
}
