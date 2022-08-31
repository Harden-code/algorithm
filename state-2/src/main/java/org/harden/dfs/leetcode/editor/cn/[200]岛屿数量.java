//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1794 👎 0

package org.harden.dfs.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-07-13 21:38:08
 */
class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] image={{'1','1','1','1','0'},{'1','1','0','1','0'}
                ,{'1','1','0','0','0'},{'0','0','0','0','0'}};
        solution.numIslands(image);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int count = 0;
        private boolean[][] visited;

        private int[][] dic = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int numIslands(char[][] grid) {
            //对每个元素进行dfs 通过visited来判断是否进入
            int height = grid.length;
            int width = grid[0].length;
            visited = new boolean[height][width];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j]=='1'&&!visited[i][j]){
                        dfs(grid,height,width,i,j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int height, int width, int i, int j) {
            visited[i][j] = true;
            for (int k = 0; k < dic.length; k++) {
                int new_i = i + dic[k][0];
                int new_j = j + dic[k][1];
                if (new_i < 0 || new_j < 0 || new_i >= height || new_j >= width
                        || grid[new_i][new_j] == '0' || visited[new_i][new_j]) {
                    continue;
                }
                dfs(grid,height,width,new_i,new_j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}