//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 530 👎 0

package org.harden.dfs.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-07-12 21:07:54
 */
class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        solution.movingCount(38, 15, 9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int result = 0;
        //定义方向
        private int[][] dic = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        private boolean[][] visited;

        public int movingCount(int m, int n, int k) {
            visited = new boolean[m][n];
            dfs(m, n, k, 0, 0);
//            for (int i = 0; i < visited.length; i++) {
//                System.out.println(Arrays.toString(visited[i]));
//            }
            return result;
        }

        private void dfs(int m, int n, int p, int i, int j) {
            //记录已经访问过的对象
            visited[i][j] = true;
            result++;
            for (int k = 0; k < dic.length; k++) {
                int new_i = i + dic[k][0];
                int new_j = j + dic[k][1];
                //这就判断下一个是否满足条件，所以没有添加递归终止条件
                // ==-1 ==m 太冗余
                if (new_i < 0 || new_j < 0 || new_i >= m || new_j >= n
                        || visited[new_i][new_j] || is(new_i, new_j, p)) {
                    continue;
                }
                dfs(m, n, p, new_i, new_j);
            }
        }

        private boolean is(int i, int j, int k) {
            int sum = 0;
            //条件
            while (i != 0) {
                sum += i % 10;
                i = i / 10;
            }
            while (j != 0) {
                sum += j % 10;
                j = j / 10;
            }
            return sum > k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}