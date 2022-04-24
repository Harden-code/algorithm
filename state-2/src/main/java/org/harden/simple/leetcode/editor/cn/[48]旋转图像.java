//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 👍 1219 👎 0

package org.harden.simple.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-03-26 18:13:45
 */
class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        solution.rotate(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate1(int[][] matrix) {
            //先拷贝一个矩阵出来 不复制的话值会被覆盖
            //反向->旋转90规律：第一行->最后一列 第二行->倒数第二列
            //i,j->i+1(j),w-1-i
            int h = matrix.length;
            int w = matrix[0].length;
            int[][] dump = new int[h][w];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    dump[i][j] = matrix[i][j];
                }
            }

            /**
             * 1 2 3  应该从第一列反推第一行
             * 4 5 6  i,j=>h-1-j,i
             * 7 8 9
             */
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = dump[h - 1 - j][i];
                }
            }
        }

        public void rotate(int[][] matrix) {
            /**
             * 1 2 3  先旋转外圈，在旋转内圈
             * 4 5 6  外圈先找到4个定点，让四个定点开始交换位置
             * 7 8 9
             */
            //记录旋转的次数
            int n = matrix.length;

            //找 0,0为参考点 其他三个点根据参考点的变动而变动
            int i1 = 0;
            int j1 = 0;

            //在n>1表示 圈数已经旋转完
            while (n > 1) {
                //缩圈
                int i2 = i1;
                int j2 = n + j1 - 1;

                int i3 = n + i1 - 1;
                int j3 = j1;

                int i4 = n + i1 - 1;
                int j4 = n + j1 - 1;

                for (int i = 0; i <= n - 2; i++) {
                    int p1 = i1 + 0;
                    int q1 = j1 + i;

                    int p2 = i2 + i;
                    int q2 = j2 + 0;

                    int p3 = i3 - i;
                    int q3 = j3 + 0;

                    int p4 = i4 + 0;
                    int q4 = j4 - i;

                    swap(matrix, p1, q1, p2, q2, p3, q3, p4, q4);
                }
                //缩圈
                i1++;
                j1++;
                //2的原因 两个定点
                n -= 2;
            }
        }

        public void swap(int[][] matrix, int i1_i, int j1_j, int i2_i, int j2_j, int i3_i, int j3_j, int i4_i, int j4_j) {
            int temp = matrix[i1_i][j1_j];
            matrix[i1_i][j1_j] = matrix[i3_i][j3_j];
            matrix[i3_i][j3_j] = matrix[i4_i][j4_j];
            matrix[i4_i][j4_j] = matrix[i2_i][j2_j];
            matrix[i2_i][j2_j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}