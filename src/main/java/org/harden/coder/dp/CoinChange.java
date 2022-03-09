package org.harden.coder.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/24 19:48
 * 文件说明：322. 零钱兑换 </p>
 */
public class CoinChange {

    private int result = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        //改成爬楼梯问题 coins数组里面代表了,能爬楼梯走的步数
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //i代表楼梯数
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE && dp[i - coins[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - coins[j]] + 1;
                }
            }
        }
        Print.print(dp);
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        //每中金额需要几个币
        int[][] dp = new int[coins.length][amount + 1];
        //dp[i][amount]=min(dp[i-1][j-k*amount[i]])
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k <= amount / coins[0]; k++) {
            dp[0][k * coins[0]] = k;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                for (int k = 0; k <= amount / coins[i]; k++) {
                    if (j - k * coins[i] >= 0 && dp[i - 1][j - k * coins[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j - k * coins[i]] + k;
                    }

                }
            }
        }
        Print.print(dp);
        return dp[coins.length - 1][amount] == 0 || dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
    }

    public int coinChangeBak(int[] coins, int amount) {
        backTrace(coins, new ArrayList<>(), amount, 0);
        return result;
    }

    public void backTrace(int[] coins, List<Integer> path, int amount, int k) {
        if (amount <= 0 || k == coins.length) {
//            System.out.println(amount);
            if (amount == 0) {
                result = Math.min(result, path.size());
            }
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            backTrace(coins, path, amount, k + 1);
            if (amount - coins[k] >= 0) {
                path.add(coins[k]);
                backTrace(coins, path, amount - coins[i], k + 1);
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
//        int[] i = {1, 2};
        int amount = 10;
        int[] i = {1, 2, 5};
        System.out.println(coinChange.coinChange1(i, amount));
    }
}
