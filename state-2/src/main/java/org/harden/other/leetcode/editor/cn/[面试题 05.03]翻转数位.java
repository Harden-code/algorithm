//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(110111011112)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(01112)
//输出: 4
// 
// Related Topics 位运算 动态规划 👍 84 👎 0

package org.harden.other.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-08-30 22:30:13
 */
class ReverseBitsLcci {
    public static void main(String[] args) {
        Solution solution = new ReverseBitsLcci().new Solution();
        solution.reverseBits(1775);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverseBits(int num) {
            if(num==1){
                return 2;
            }
            if(num==0){
                return 1;
            }
            List<Integer> dump = new ArrayList<>();
            while (num != 0) {
                int i = num % 2;
                dump.add(i);
                num /= 2;
            }
            int[] left = new int[dump.size()];
            for (int i = 0; i < dump.size(); i++) {
                if (dump.get(i) != 0 && i - 1 >= 0 && left[i - 1] != 0) {
                    left[i] = left[i - 1] + 1;
                } else if (dump.get(i) == 0) {
                    left[i] = 0;
                } else {
                    left[i] = 1;
                }
            }
            int[] right = new int[left.length];
            right[left.length - 1] = left[left.length - 1];
            for (int i = right.length - 2; i >= 0; i--) {
                if (left[i] != 0) {
                    right[i] = Math.max(left[i], right[i + 1]);
                }
            }
            int result = 0;
            int count=0;
            for (int i = 0; i < right.length; i++) {
                if(right[i]==0){
                    int sum=1;
                    if (i - 1 >= 0 && right[i - 1] != 0  ){
                        sum+=right[i - 1];

                    }
                    if(i + 1 <= right.length - 1 && right[i + 1] != 0){
                        sum+=right[i + 1];
                    }
                    result = Math.max(sum, result);
                }else {
                    count++;
                }
            }
            if(count==right.length){
                return count+1;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}