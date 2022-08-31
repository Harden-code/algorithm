//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差 
//
// 
//
// 示例： 
//
// 
//输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//输出：3，即数值对(11, 8)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 100000 
// -2147483648 <= a[i], b[i] <= 2147483647 
// 正确结果在区间 [0, 2147483647] 内 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 59 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-08-23 21:53:40
 */
class SmallestDifferenceLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestDifferenceLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            int min = Integer.MAX_VALUE;
            Arrays.sort(a);
            Arrays.sort(b);
            int i = 0;
            int j = 0;
            while (i < a.length && j < b.length) {
                long a1=a[i];
                long a2=b[j];
                min=(int) Math.min(Math.abs(a1-a2),min);
                if(a[i]>b[j]){
                    j++;
                }else {
                    i++;
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}