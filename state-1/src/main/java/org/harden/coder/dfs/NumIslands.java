package org.harden.coder.dfs;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/13 21:24
 * 文件说明： </p>
 */
public class NumIslands {
    private int count = 0;

    private boolean[][] visit;
    /**
     * 运动方向
     */
    private int[][] dic = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        visit = new boolean[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //如果遇到1进行dfs计算个数
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(grid, width, height, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int width, int height, int w, int h) {
        visit[w][h] = true;
        //把所有访问都打上标记
        for (int i = 0; i < dic.length; i++) {
            int newW = w + dic[i][0];
            int newH = h + dic[i][1];
            //判断下一个元素
            if (newW < 0 || newW >= width || newH < 0 || newH >= height
                    || visit[newW][newH] || grid[newW][newH] == '0') {
                continue;
            }
            dfs(grid, width, height, newW, newH);
        }
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] image={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands.numIslands(image));
    }
}
