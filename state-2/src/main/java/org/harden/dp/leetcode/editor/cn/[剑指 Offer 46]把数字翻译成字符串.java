//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 472 👎 0

package org.harden.dp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-08-09 21:30:16
 */
class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        solution.translateNum(0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            //特殊
            if(num==0){
                return 1;
            }
            List<Integer> nums = new ArrayList<>();
            int k = num;
            while (k != 0) {
                int i = k % 10;
                nums.add(i);
                k = k / 10;
            }
            int[] path = new int[nums.size()];
            for (int i = 0; i < path.length; i++) {
                path[i] = nums.get(nums.size() - 1 - i);
            }
            int[] dp = new int[path.length];
            dp[0] = 1;
            if (dp.length == 1) {
                return dp[0];
            }
            if(is(path[0],path[1])){
                dp[1]=2;
            }else {
                dp[1]=1;
            }
            for (int i = 2; i < dp.length; i++) {
                //判断前个节点是否满足
                //满足的话可以由-1 和 -2组合成

                // 1 8 8 2 2
                // 1 2
                //     2 2
                if (is(path[i - 1], path[i])) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    //不满足由-1节点推导
                    dp[i] += dp[i - 1];
                }
            }
//            System.out.println(Arrays.toString(dp));
            return dp[dp.length - 1];
        }

        private boolean is(int p, int n) {
            if (p == 0) {
                return false;
            }
            int sum = p * 10 + n;
            return sum <= 25;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}