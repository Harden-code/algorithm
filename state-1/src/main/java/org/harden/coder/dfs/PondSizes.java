package org.harden.coder.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/13 21:55
 * 文件说明：面试题 16.19. 水域大小 </p>
 * <p>
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PondSizes {

    private int count;

    private boolean[][] visit;
    /**
     * 8个方向
     */
    private int[][] dic = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}
            , {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};

    public int[] pondSizes(int[][] land) {
        List<Integer> result = new ArrayList<>();

        int width = land.length;
        int height = land[0].length;
        visit = new boolean[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //如果遇到1进行dfs计算个数
                if (land[i][j] == 0 && !visit[i][j]) {
                    dfs(land, width, height, i, j);
                    if(count!=0){
                        result.add(count);
                        count=0;

                    }
                }
            }
        }

        int[] temp = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            temp[i] = result.get(i);
        }
        Arrays.sort(temp);
        return temp;
    }

    private void dfs(int[][] land, int width, int height, int w, int h) {
        visit[w][h] = true;
        count++;
        for (int i = 0; i < dic.length; i++) {
            int newW = w + dic[i][0];
            int newH = h + dic[i][1];
            //用下一个来进行判断
            if (newW < 0 || newW >= width || newH < 0 || newH >= height
                    || visit[newW][newH] || land[newW][newH] != 0) {
                continue;
            }
            dfs(land, width, height, newW, newH);
        }

    }

    public static void main(String[] args) {
        PondSizes pondSizes = new PondSizes();
        int[][] image = {{0,2,1,0}, {0,1,0,1}, {1,1,0,1}, {0,1,0,1}};
        System.out.println(Arrays.toString(pondSizes.pondSizes(image)));
    }
}
