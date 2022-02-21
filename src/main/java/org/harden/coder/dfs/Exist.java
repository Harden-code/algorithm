package org.harden.coder.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/14 22:09
 * 文件说明： 79. 单词搜索</p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，
 * 返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {
    private boolean result;

    private boolean[][] visit;

    private int[][] dic = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {

        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);
        int width = board.length;
        int height = board[0].length;


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == start && !result) {
                    //进去一次dfs,就的换个表盘
                    visit = new boolean[width][height];
                    dfs(i, j, width, height, end, board, word, new ArrayList<>(), 1);
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, int width, int height, char end, char[][] board, String word, List<Character> path, int c) {
        path.add(board[i][j]);
        visit[i][j] = true;
        if (board[i][j] == end && path.size() == word.length()) {

            StringBuilder builder = new StringBuilder();
            for (int p = 0; p < path.size(); p++) {
                builder.append(path.get(p));
            }
            if (builder.toString().equals(word)) {
                result = true;
            }
            return;
        }
        for (int k = 0; k < dic.length; k++) {
            int newI = dic[k][0] + i;
            int newJ = dic[k][1] + j;
            if (newI < 0 || newI >= width || newJ < 0 || newJ >= height
                    || visit[newI][newJ] || board[newI][newJ] != word.charAt(c)) {
                continue;
            }
            dfs(newI, newJ, width, height, end, board, word, path, c + 1);
            path.remove(path.size() - 1);
            //它递归进去,就会设置为true。跳出来去除条件
            visit[newI][newJ] = false;
        }
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
//        char[][] chars1={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        System.out.println(exist.exist(chars1, "ABCCED"));
//        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(exist.exist(chars, "SEE"));
//        char[][] chars2={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        System.out.println(exist.exist(chars2, "AAB"));
        char[][] chars3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist.exist(chars3, "ABCESEEEFS"));
    }
}
