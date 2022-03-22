package org.harden.coder.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/23 21:46
 * 文件说明： </p>
 */
public class Print {
    public static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public static void print(List<List<Integer>> dp) {
        for (int i = 0; i < dp.size(); i++) {
            List<Integer> list = dp.get(i);
            for (int j = 0; j <list.size(); j++) {
                System.out.print(dp.get(i).get(j));
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public static void print(int[] dp){
        Arrays.stream(dp).forEach(System.out::print);
        System.out.println();
    }
}
