package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/30 13:09
 * 文件说明：
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int outLow = 0;
        int outHeight = matrix.length-1;
        int row = matrix[0].length - 1;
        //先处理竖
        while (outLow <= outHeight) {
            int outMid = outLow + (outHeight - outLow) / 2;
            if (matrix[outMid][row] == target) {
                return true;
            } else if (matrix[outMid][row] > target) {
                int innerLow = 0;
                int innerHeight = matrix[0].length - 1;
                while (innerLow <= innerHeight) {
                    int mid = innerLow + (innerHeight - innerLow) / 2;
                    if (matrix[outMid][mid] == target) {
                        return true;
                    } else if (matrix[outMid][mid] > target) {
                        innerHeight = mid - 1;
                    } else {
                        innerLow = mid + 1;
                    }
                }
                outHeight = outMid - 1;
            } else {
                outLow = outMid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16}, {23, 30, 34, 60}};
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(a, 34));
    }
}
