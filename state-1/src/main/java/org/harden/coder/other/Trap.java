package org.harden.coder.other;

import org.harden.coder.dp.Print;

/**
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trap {
    public int trap(int[] height) {
        int result = 0;
        //建立左前缀，指的是当前节点最右边的最大高度
        int[] leftMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = height[i];
            if (i - 1 >= 0 && leftMax[i-1] > height[i]) {
                leftMax[i]=leftMax[i-1] ;
            }
        }
        //建立右前缀，指的的当前节点最右边的最大高度
        int[] rightMax = new int[height.length];
        for (int j =  height.length-1; j >=0; j--) {
            rightMax[j]=height[j];
            if (j + 1<height.length && rightMax[j+1] > height[j]) {
                rightMax[j]=rightMax[j+1];
            }
        }


        for (int i = 0; i < height.length; i++) {
            //向左边比i位大 最大
            int left = 0;
            if(i-1>=0){
                left=leftMax[i-1];
            }

            //向右边找比i位大的
            int right = 0;
            if(i+1<height.length){
                right=rightMax[i+1];
            }

            int temp = Math.min(left, right) - height[i];
            if (temp > 0) {
                result += temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap trap = new Trap();
        System.out.println(trap.trap(nums));
    }
}
