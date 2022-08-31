//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 矩阵 👍 843 👎 0

package org.harden.dp.leetcode.editor.cn;

import static org.harden.dp.leetcode.editor.cn.TargetSum.print;

/**
 * @author junsenfu
 * @date 2022-07-30 21:21:05
 */
class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        int[][] path={{0,1},{0,0}};
        solution.uniquePathsWithObstacles(path);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            //横
            boolean flag = false;
            for (int i = 0; i < dp[0].length; i++) {
                if (obstacleGrid[0][i] == 1 || flag) {
                    dp[0][i] = 0;
                    flag = true;
                } else {
                    dp[0][i] = 1;
                }

            }
            //竖
            flag = false;
            for (int i = 0; i < dp.length; i++) {
                if (obstacleGrid[i][0] == 1 || flag) {
                    dp[i][0] = 0;
                    flag = true;
                } else {
                    dp[i][0] = 1;
                }
            }
            for (int i = 1; i < obstacleGrid.length; i++) {
                for (int j = 1; j < obstacleGrid[i].length; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        //有障碍物就不能走
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }

                }
            }
//            print(dp);
            return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}