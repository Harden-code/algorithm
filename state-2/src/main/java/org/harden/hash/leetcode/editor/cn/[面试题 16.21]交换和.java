//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 数组 哈希表 二分查找 排序 👍 35 👎 0

package org.harden.hash.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author  junsenfu
 * @date 2022-05-18 23:15:12
 */
class SumSwapLcci{
    public static void main(String[] args) {
        Solution solution = new SumSwapLcci().new Solution();
//        int[] array1={4, 1, 2, 1, 1, 2};
//        int[] array2={3, 6, 3, 3};
        int[] array1={519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] array2= {52, 20, 78, 50, 38, 96, 81, 20};
        solution.findSwapValues(array1,array2);
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1= Arrays.stream(array1).sum();
        int sum2= Arrays.stream(array2).sum();
        //奇数

        if(((sum1+sum2)&1)==1){
            return new int[]{};
        }
        int value=(sum1+sum2)/2;


        Set<Integer> set1=new HashSet<>();
        for (int i = 0; i < array1.length; i++) {
            set1.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            //sum2-array2[i]+k=value
            int k=value-(sum2-array2[i]);
            if(set1.contains(k)){
                return new int[]{k,array2[i]};
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}