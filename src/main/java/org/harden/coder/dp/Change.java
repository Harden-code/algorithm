package org.harden.coder.dp;

/**
 * 518. 零钱兑换 II
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Change {
    public int change(int amount, int[] coins) {
        //固定金额凑成方法
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <=amount / coins[0]; i++) {
            dp[0][i * coins[0]] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k <= amount / coins[i]; k++) {
                    //0-amount/coins[i]
                    if (j - k * coins[i] >= 0) {
                        dp[i][j]+=dp[i-1][j-k*coins[i]];
                    }
                }
            }
        }
        Print.print(dp);
        return dp[coins.length-1][amount];
    }

    public static void main(String[] args) {
        Change change = new Change();
//        int[] i = {1, 2};
        int amount = 5;
        int[] i = {1, 2, 5};
        change.change(amount,i);
    }
}
