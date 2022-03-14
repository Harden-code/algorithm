package org.harden.coder.dp;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/21 21:21
 * 文件说明：64. 最小路径和 </p>
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid,请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入：grid = [[1,3,1]
 * ,[1,5,1]
 * ,[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        //状态模型 一个阶段 有2种不同走向 dp[i][j]=dp[i-1][j]+dp[i][j-1]
        //每个空格是该状态的值
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        //初始化第一阶段,横向走完，纵向走完 为初始化
        for (int i = 1; i < width; i++) {
            dp[0][i] = grid[0][i];
            dp[0][i] += dp[0][i - 1];
        }
        for (int j = 1; j < height; j++) {
            dp[j][0] = grid[j][0];
            dp[j][0] += dp[j - 1][0];
        }
        print(dp);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //由初始化阶段的上一个推到下一个
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[height - 1][width - 1];
    }

    private void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}
                , {1, 5, 1}
                , {4, 2, 1}};

        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}};

        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid1));
    }
}
