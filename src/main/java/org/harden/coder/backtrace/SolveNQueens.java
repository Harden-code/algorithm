package org.harden.coder.backtrace;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/19 12:47
 * 文件说明： 面试题 08.12. 八皇后</p>
 */
public class SolveNQueens {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] paths = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paths[i][j] = '.';
            }
        }
        backTrance(paths, 0, n);
        return result;
    }

    /**
     * k 代表列
     */
    public void backTrance(char[][] paths, int row, int n) {
        if (n == row) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < paths.length; i++) {
                temp.add(new String(paths[i]));
            }
            result.add(temp);
            return;
        }
        //col 列  用行去递归 ,列递归会出问题
        for (int col = 0; col < n; col++) {
            //先列举所有，如果遇到不符合的，直接回退
            if (isOk(paths, row, col, n)) {
                paths[row][col] = 'Q';
                //行扩展
                backTrance(paths, row + 1, n);
                paths[row][col] = '.';
            }
        }
    }

    public boolean isOk(char[][] paths, int row, int col, int n) {
        //列
        for (int i = 0; i < n; i++) {
            if (paths[i][col] == 'Q') {
                return false;
            }
        }
        //对角线 \  /
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (paths[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while (j < n && i >= 0) {
            if (paths[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }


    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        lists.stream().forEach(e -> {
            e.forEach(System.out::println);
            System.out.println();
        });
    }
}
