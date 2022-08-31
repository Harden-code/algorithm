//编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。 
//
// 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。 
//
// 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。 
//
// 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。 
//
// 
//
// 示例： 
//
// 
//输入：
//image = [[1,1,1],[1,1,0],[1,0,1]] 
//sr = 1, sc = 1, newColor = 2
//输出：[[2,2,2],[2,2,0],[2,0,1]]
//解释: 
//初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
//初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
//注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
// 
//
// 
//
// 提示： 
//
// 
// image 和 image[0] 的长度均在范围 [1, 50] 内。 
// 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。 
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 50 👎 0

package org.harden.dfs.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-07-12 22:12:31
 */
class ColorFillLcci {
    public static void main(String[] args) {
        Solution solution = new ColorFillLcci().new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        solution.floodFill(image, 1, 1, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean[][] visit;

        private int[][] dic = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int i = image.length;
            int j = image[0].length;
            visit = new boolean[i][j];
            int target=image[sr][sc];
            dfs(image, i, j, sr, sc, newColor,target);
            return image;
        }

        private void dfs(int[][] image, int i, int j, int sr, int sc, int newColor,int target) {
            visit[sr][sc] = true;
            image[sr][sc] = newColor;
            for (int k = 0; k < dic.length; k++) {
                int new_i = sr + dic[k][0];
                int new_j = sc + dic[k][1];
                if (new_i < 0 || new_j < 0 || new_j >= j || new_i >= i
                        || visit[new_i][new_j]
                        || image[new_i][new_j] != target) {
                    continue;
                }
                dfs(image, i, j, new_i, new_j, newColor,target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}