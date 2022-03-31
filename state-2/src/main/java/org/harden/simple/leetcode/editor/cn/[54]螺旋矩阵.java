//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1026 👎 0

package org.harden.simple.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-03-23 22:55:20
 */
class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = {{1, 2,3}, {4,5,6}, {7,8,9}};
        solution.spiralOrder(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            //记录外围的位置
            //向左 top+1
            int top = 0;
            //向下 right-1
            int left = 0;
            //向右 below-1
            int below = matrix.length - 1;
            //向上 left+1
            int right = matrix[0].length - 1;
            while (true) {
                //向左
                for (int i = top; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;

                //向下
                if (top > below) break;
                for (int i = top; i <= below; i++) {
                    result.add(matrix[i][right]);
                }
                right--;

                if (left > right) break;
                //left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[below][i]);
                }
                below--;
                if (top > below) break;
                //top
                for (int i = below; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                if (left > right) break;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}