package org.harden.coder.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 17:47
 * 文件说明：
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class FindSwapValues {
    public int[] findSwapValues(int[] array1, int[] array2) {
        //1 两个总和相除 求插值
        //2 比较不同
        int result1 = 0;
//        Set<Integer> set1 = new HashSet<>();
        for (int i : array1) {
            result1 += i;
//            set1.add(i);
        }
        int result2 = 0;
        Set<Integer> set2 = new HashSet<>();
        for (int i : array2) {
            result2 += i;
            set2.add(i);
        }
        int sum = result1+result2;
        //只能是偶数
        if(sum%2==1){
            return new int[0];
        }


        int dif=sum/2-result1;
        for (int i = 0; i < array1.length; i++) {
            //相差 一边减少 一边增加a
            if (set2.contains(dif + array1[i]) ) {
                return new int[]{array1[i], dif + array1[i]};
            }
        }
        return new int[0];
    }
}
