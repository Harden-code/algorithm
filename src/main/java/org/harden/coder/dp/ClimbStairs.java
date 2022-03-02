package org.harden.coder.dp;

import java.util.Arrays;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/28 21:11
 * 文件说明： 70. 爬楼梯</p>
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n==1||n==2){
            return n;
        }

        //n 代表每层有几总走法
        int[] dp=new int[n+1];
        //一层楼代表 1种走法
        dp[1]=1;
        //二层楼代表 2种走法
        dp[2]=2;
        //状态转移 dp[i]=dp[i-1]+dp[i-2]
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(3));
    }
}
