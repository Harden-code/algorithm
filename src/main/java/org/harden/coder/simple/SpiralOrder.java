package org.harden.coder.simple;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/5 17:13
 * 文件说明：
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * (i,j)->(j,n-i-1)
 *
 * </p>
 */
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int h = matrix.length - 1;
        int w = matrix[0].length - 1;
        int i = 0;
        int j = 0;
        while (i <= h-1 && j <= w-1) {
            //左移动
            if (i == 0 && j <= w ) {
                result.add(matrix[0][j]);
                j++;
            }
            if (i >= 0 && j == w) {
                result.add(matrix[i][w]);
                i++;
            }
            if (i == h && j < w) {
                result.add(matrix[h][j]);
                j--;
            }
            if (i <= h && j == 0) {
                result.add(matrix[j][i]);
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix= {{1,4,7},{2,5,8},{3,6,9}};
        spiralOrder(matrix);
    }
}
