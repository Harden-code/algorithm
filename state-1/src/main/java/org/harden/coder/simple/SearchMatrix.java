package org.harden.coder.simple;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/4 12:32
 * 文件说明：
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
 * [10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 *
 * </p>
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            //判断是否大于最大行
            if (target > matrix[i][m - 1]) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        //高
        int n = matrix.length;
        //宽
        int m = matrix[0].length;
        int h = n - 1;
        //宽度
        int j=m-1;
        int i = 0;
        //从1层最高位遍历
        while (i <=h && j >= 0) {
            if(matrix[i][j]==target){
                return true;
            }
            // 向左移动
            if(matrix[i][j]>target){
                j--;
                continue;
            }
            // 向下移动
            if(matrix[i][j]<target){
                i++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//       int[][] matrix= {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        System.out.println(searchMatrix1(matrix, 5));
        int[][] matrix1={{1}};

        System.out.println(searchMatrix1(matrix1, 1));
    }
}
