package org.harden.coder.queue;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/20 18:02
 * 文件说明：
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * </p>
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int result=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<heights.length;i++){

            //记录单调递增 记录单调递减 区间的面积
            while(!stack.isEmpty()){

            }

        }
        return result;
    }
}
