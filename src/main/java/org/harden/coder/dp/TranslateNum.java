package org.harden.coder.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */

public class TranslateNum {


    public int translateNum(int num) {

        List<Integer> list = new ArrayList<>();

        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(list.size() - i - 1);
        }
        //转换成 爬楼梯问题 i-1 i-2取这个两个状态来判断是否符合规则=>dp[i]在第i个状态总共有多少种方法
        //dp[i]=dp[i-1]+dp[i-2]
        int[] dp = new int[list.size() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            if (i - 2 >= 0 && validate(temp[i - 2], temp[i - 1])) {
                dp[i] += dp[i - 2];
            }
        }
        Print.print(dp);
        return dp[dp.length - 1];
    }

    public boolean validate(int a, int b) {
        if (a == 0) {
            return false;
        }
        return a * 10 + b <= 25;
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        translateNum.translateNum(1525);
    }
}
