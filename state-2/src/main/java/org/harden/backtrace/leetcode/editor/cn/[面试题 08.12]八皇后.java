//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 数组 回溯 👍 150 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import org.harden.tree.leetcode.editor.cn.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-06-29 21:44:57
 */
class EightQueensLcci {
    public static void main(String[] args) {
        Solution solution = new EightQueensLcci().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> all = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] games = new char[n][n];
            init(games);
            backTrace(games, 0, n);
            return all;
        }

        private void init(char[][] path) {
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path[i].length; j++) {
                    path[i][j] = '.';
                }
            }
        }

        private void backTrace(char[][] path, int row, int k) {
            if (row == k) {
                List<String> result = new ArrayList<>();
                for (int i = 0; i < path.length; i++) {
                    String s = new String(path[i]);
                    result.add(s);
                }
                all.add(result);
                return;
            }
            for (int col = 0; col < k; col++) {
                //进行决策,进不去直接回退
                if (is(path, row, col)) {
                    path[row][col]='Q';
                    backTrace(path,row+1,k);
                    //回退
                    path[row][col]='.';
                }
            }
        }

        private boolean is(char[][] path, int row, int col) {
            //横 path[row] 直接过因为每行只放一个所以不用
//            for (int i = 0; i < col; i++) {
//                if (path[row][col] == 'Q') {
//                    return false;
//                }
//            }
            //竖
            for (int j = row; j >=0; j--) {
                if (path[j][col] == 'Q') {
                    return false;
                }
            }
            //左斜
            int i = row;
            int j = col;
            while (i >= 0 && j >= 0) {
                if (path[i][j] == 'Q') {
                    return false;
                }
                i--;
                j--;
            }
            //右斜
            i = row;
            j = col;
            while (i >= 0 && j <= path.length - 1) {
                if (path[i][j] == 'Q') {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}