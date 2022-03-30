//设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（" "）中。 
// 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。 
// "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 
//"Pending"。 
//
// 示例 1： 
//
// 输入： board = ["O X"," XO","X O"]
//输出： "X"
// 
//
// 示例 2： 
//
// 输入： board = ["OOX","XXO","OXO"]
//输出： "Draw"
//解释： 没有玩家获胜且不存在空位
// 
//
// 示例 3： 
//
// 输入： board = ["OOX","XXO","OX "]
//输出： "Pending"
//解释： 没有玩家获胜且仍存在空位
// 
//
// 提示： 
//
// 
// 1 <= board.length == board[i].length <= 100 
// 输入一定遵循井字棋规则 
// 
// Related Topics 数组 计数 矩阵 👍 31 👎 0

package org.harden.simple.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-03-22 22:05:36
 */
class TicTacToeLcci {
    public static void main(String[] args) {
        Solution solution = new TicTacToeLcci().new Solution();
        String[] strings = {"O X", " XO", "X O"};
        solution.tictactoe(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String tictactoe(String[] board) {
            int n = board[0].length();
            //记录是否遍历过,减少遍历次数
            boolean Pending = false;
            boolean[][] games = new boolean[board.length][board[0].length()];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length(); j++) {
                    char c = board[i].charAt(j);
                    if (c == 'O' && check(board, i, j, c, n)) {
                        return "O";
                    } else if (c == 'X' && check(board, i, j, c, n)) {
                        return "X";
                    } else if (c == ' ') {
                        //做个记录 是平局没下完情况
                        Pending = true;
                    }
                }
            }
            if (Pending) {
                return "Pending";
            }
            //平局
            return "Draw";
        }

        //i j 下标 n满足个数
        public boolean check(String[] board, int i, int j, char c, int n) {
            int k = 0;
            //横
            for (int p = 0; p < board[i].length(); p++) {
                if (board[i].charAt(p) == c) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == n) {
                return true;
            }

            k = 0;
            //竖
            for (int p = 0; p < board.length; p++) {
                if (board[p].charAt(j) == c) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == n) {
                return true;
            }

            k = 0;
            //左斜
            int p = i;
            int q = j;
            while (p < board[0].length() && q < board.length) {
                if (board[p].charAt(q) == c) {
                    k++;
                } else {
                    break;
                }
                p++;
                q++;
            }
            p = i - 1;
            q = j - 1;
            //0是可达的 len可达
            while (p >= 0 && q >= 0) {
                if (board[p].charAt(q) == c) {
                    k++;
                } else {
                    break;
                }
                p--;
                q--;
            }
            if (k == n) {
                return true;
            }

            k = 0;
            //右斜
            p = i;
            q = j;
            //右上斜
            while (p >= 0 && q < board[0].length()) {
                if (board[p].charAt(q) == c) {
                    k++;
                } else {
                    break;
                }
                p--;
                q++;
            }

            //右下斜 去重 ij
            p = i + 1;
            q = j - 1;
            while (p < board.length && q >= 0) {
                if (board[p].charAt(q) == c) {
                    k++;
                } else {
                    break;
                }
                p++;
                q--;
            }
            if (k == n) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}