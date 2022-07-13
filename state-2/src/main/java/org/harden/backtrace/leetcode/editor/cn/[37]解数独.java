//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 👍 1310 👎 0

package org.harden.backtrace.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-07-02 17:58:52
 */
class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solution.solveSudoku(board);


    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //横
        private boolean[][] rows = new boolean[9][10];
        //竖
        private boolean[][] cols = new boolean[9][10];
        //9宫格
        private boolean[][][] cels = new boolean[3][3][10];

        //只需要一种 就可以提前退出
        private boolean result = false;

        public void solveSudoku(char[][] board) {
            init(board);
            backTrace(board, 0, 0);
        }

        private void backTrace(char[][] board, int i, int j) {
//            if (result) {
//                return;
//            }
            if (i == 9) {
                result = true;
                return;
            }
            if (board[i][j] != '.') {
                //是数字 跳过
                int row = i;//行
                int col = j + 1;//列
                //列==8就要换行 8包含本列
                if (col == 9) {
                    row = row + 1;
                    col = 0;
                }
                backTrace(board, row, col);
            } else {
                //通过对每一个格子做决策
                for (int k = 1; k <= 9; k++) {
                    if (!rows[i][k] && !cols[j][k] && !cels[i / 3][j / 3][k]) {
                        //是数字 跳过
                        int row = i;//行
                        int col = j + 1;//列
                        //列==8就要换行
                        if (col == 9) {
                            row = row + 1;
                            col = 0;
                        }
                        rows[i][k] = true;
                        cols[j][k] = true;
                        cels[i / 3][j / 3][k] = true;
                        board[i][j] = (char) (k + '0');
                        backTrace(board, row, col);
                        //为了避免
                        if(result){
                            return;
                        }
                        board[i][j] = '.';
                        rows[i][k] = false;
                        cols[j][k] = false;
                        cels[i / 3][j / 3][k] = false;
                    }
                }
            }
        }

        private void init(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        int value = board[i][j] - '0';
                        rows[i][value] = true;
                        cols[j][value] = true;
                        cels[i / 3][j / 3][value] = true;
                    }
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}