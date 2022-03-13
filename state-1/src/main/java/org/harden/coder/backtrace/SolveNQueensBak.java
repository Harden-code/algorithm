package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/19 21:29
 * 文件说明：  面试题 08.12. 八皇后</p>
 */
public class SolveNQueensBak {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        if (n == 0) {
            return result;
        }
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        backTrance(chars, 0, n);
        return result;
    }

    public void backTrance(char[][] chars, int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                temp.add(new String(chars[i]));
            }
            result.add(temp);
            return;
        }
        //用列去递归 是从右到左(判断方法困难)，用行去递归是从左到右 从上到下
        for (int col = 0; col < n; col++) {
            if (isOk(chars, row, col, n)) {
                chars[row][col] = 'Q';
                backTrance(chars, row + 1, n);
                chars[row][col] = '.';
            }
        }
    }

    public boolean isOk(char[][] chars, int row, int col, int n) {
        //行可以省区判断，因为递归row一直在变动不会有重复
        //列
        for (int i = 0; i < n; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }
        //左斜角
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (chars[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        //右斜角
        i = row - 1;
        j = col + 1;
        while (j < n && i >= 0) {
            if (chars[i][j] == 'Q') {
                return false;
            }
            j++;
            i--;
        }
        return true;
    }
    public static void main(String[] args) {
        SolveNQueensBak solveNQueens = new SolveNQueensBak();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        lists.stream().forEach(e -> {
            e.forEach(System.out::println);
            System.out.println();
        });
    }
}
