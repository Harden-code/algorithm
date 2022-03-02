package org.harden.coder.dp;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/23 21:50
 * 文件说明： 63. 不同路径 II</p>
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        /**
         * 1 1 1
         * 1 0 1
         * 1 1 2
         * dp[i][j]=dp[i-1][j] + dp[i][j-1]
         */
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            //如果前面有1 后面全部不能走
            if(obstacleGrid[i][0]==1){
                dp[i][0] = 0;
                break;
            }else {
                dp[i][0] = 1;
            }

        }
        for (int i = 0; i < width; i++) {
            if(obstacleGrid[0][i]==1){
                dp[0][i] = 0;
                break;
            }else {
                dp[0][i] = 1;
            }

        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = -1;
                }
            }
        }
        Print.print(dp);
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        Print.print(dp);
        return dp[height - 1][width - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles u = new UniquePathsWithObstacles();
//        int[][] path={{0,0,0},{0,1,0},{0,0,0}};
        int[][] path={{0,0},{1,1},{0,0}};
//        int[][] path={{1,0}};
        System.out.println(u.uniquePathsWithObstacles(path));
    }
}
