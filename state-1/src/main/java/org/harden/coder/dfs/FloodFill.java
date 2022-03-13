package org.harden.coder.dfs;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/10 21:49
 * 文件说明：面试题 08.10. 颜色填充 </p>
 * <p>
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。
 * 需要填充的新颜色为 newColor 。
 * <p>
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 * 输入：
 * image = [[1,1,1]
 * ,[1,1,0]
 * ,[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2]
 * ,[2,2,0]
 * ,[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FloodFill {

    private boolean[][] visit;

    private int[][] dic = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return null;
        }
        int i = image.length;
        int j = image[0].length;
        visit = new boolean[i][j];
        int target = image[sr][sc];
        // i j 也就是矩阵长度，作为终止条件
        dfs(image, i, j, sr, sc, newColor, target);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int sr, int sc, int newColor, int target) {
        visit[sr][sc] = true;
        //只要进入该方法，就说满足条件
        image[sr][sc] = newColor;
        for (int p = 0; p < dic.length; p++) {
            int newSr = dic[p][0] + sr;
            int newSc = dic[p][1] + sc;

            if (newSr < 0 || newSr >= i || newSc < 0 || newSc >= j
                    || image[newSr][newSc] != target || visit[newSr][newSc]) {
                continue;
            }
            dfs(image, i, j, newSr, newSc, newColor, target);
        }
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        floodFill.floodFill(image,1,1,2);
    }

}
