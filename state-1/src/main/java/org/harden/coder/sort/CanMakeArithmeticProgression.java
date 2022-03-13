package org.harden.coder.sort;

import java.util.Arrays;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 17:51
 * 文件说明：
 *
 * 给你一个数字数组 arr 。
 *
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 *
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class CanMakeArithmeticProgression {
    public static boolean canMakeArithmeticProgression(int[] arr) {

        //先排序
        Arrays.sort(arr);
        int tmp=arr[1]-arr[0];
        //{1,3,5,7}
        for(int i=0;i<=arr.length-2;i++){
            // i=0  1  0
            // i=1  2  1
            // i=2  3  2
            if(arr[i+1] - arr[i]!=tmp){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,7};
        canMakeArithmeticProgression(arr);
    }
}
