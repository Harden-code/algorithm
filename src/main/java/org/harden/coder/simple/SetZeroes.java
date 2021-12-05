package org.harden.coder.simple;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/4 12:33
 * 文件说明：
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * </p>
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return;
        }
        boolean[] rows = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //行
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //行
                if (rows[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
