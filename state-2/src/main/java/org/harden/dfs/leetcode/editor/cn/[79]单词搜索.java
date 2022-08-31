//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1368 👎 0

package org.harden.dfs.leetcode.editor.cn;

import java.util.List;

/**
 * @author junsenfu
 * @date 2022-07-14 22:03:08
 */
class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
//        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] chars={{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(chars, "ABCESEEEFS"));
//        char[][] chars ={{'a'}};
//        solution.exist(chars, "a");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean result = false;

        private int[][] dic = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        private boolean[][] visited;

        //dfs+加回溯
        public boolean exist(char[][] board, String word) {
            int height = board.length;
            int width = board[0].length;
            visited = new boolean[height][width];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char value = board[i][j];
                    if (value == word.charAt(0)) {
//                        visited = new boolean[height][width];
                        dfs(board, word, height, width, i, j, 1);
                        visited[i][j]=false;
                    }
                    if (result) {
                        return result;
                    }

                }
            }
            return result;
        }

        private void dfs(char[][] board, String word, int height, int width
                , int h, int w, int k) {
            visited[h][w] = true;
            //退出条件
            if (k >= word.length()) {
                if (k == word.length()){
                    result = true;
                }
                return;
            }

            for (int i = 0; i < dic.length; i++) {
                int new_i = h + dic[i][0];
                int new_j = w + dic[i][1];
                if (new_i < 0 || new_j < 0 || new_i >= height || new_j >= width
                        || visited[new_i][new_j]
                        //判断当前元素是否满足
//                        ||k+1>=word.length() k下个
                        ||word.charAt(k) != board[new_i][new_j]) {
                    continue;
                }
                dfs(board, word, height, width, new_i, new_j, k + 1);
                //要回退 进dfs h w 数当前一个的
                visited[new_i][new_j] = false;

            }
            //visited[][] 下个已经在开头就判断完,这回退上步
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}