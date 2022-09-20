package org.harden.everyday;

import java.util.*;

/**
 * 827. 最大人工岛
 */
public class LargestIsland {
    private int result = Integer.MIN_VALUE;

    private int count = 0;

    private boolean[][] visited;

    private int[][] dic = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        //标号方框
        int mark = 2;
        //记录标号的所有陆地
        int zeroCount = 0;
        int oneCount = 0;
        this.visited = new boolean[grid.length][grid[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs_mark(grid, i, j, mark);
                    map.put(mark, count);
                    mark++;
                    //记录为一岛屿个数
                    count = 0;
                    oneCount++;
                }
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        //特殊情况
        if (oneCount == 0) {
            return 1;
        }

        if (zeroCount == 0) {
            return grid.length * grid[0].length;
        }

        Set<Integer> visitedMark = new HashSet<>();//记录
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    //当前换成1
                    int all = 1;
                    //四个方向进行判断相加
                    for (int k = 0; k < dic.length; k++) {
                        int n_i = i + dic[k][0];
                        int n_j = j + dic[k][0];
                        if (n_i > grid.length - 1 || n_i < 0 || n_j < 0 || n_j > grid[0].length - 1
                                || visitedMark.contains(grid[n_i][n_j]) || grid[n_i][n_j] == 0) {
                            continue;
                        }
                        int mark_count = map.get(grid[n_i][n_j]);
//                        System.out.println(mark_count);
                        visitedMark.add(grid[n_i][n_j]);
                        all += mark_count;
                    }
                    result = Math.max(all, result);
                    visitedMark.clear();
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        return result;
    }

    private void dfs_mark(int[][] grid, int i, int j, int mark) {
        visited[i][j] = true;
        grid[i][j] = mark;
        count++;
        for (int k = 0; k < dic.length; k++) {
            int n_i = i + dic[k][0];
            int n_j = j + dic[k][1];
            if (n_i > grid.length - 1 || n_i < 0 || n_j < 0 || n_j > grid[0].length - 1
                    || visited[n_i][n_j] || grid[n_i][n_j] == 0) {
                continue;
            }
            dfs_mark(grid, n_i, n_j, mark);
        }
    }


    //暴力解法把所有为0的相加
    public int largestIsland_(int[][] grid) {
        boolean[] booleans = allZero(grid);
        if (booleans[0]) {
            return 1;
        }
        if (booleans[1]) {
            return grid.length * grid[0].length;
        }
        this.visited = new boolean[grid.length][grid[0].length];
//        boolean haveZero=false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    clear(visited);
                    result = Math.max(count, result);
                    count = 0;
                }
            }
        }

        return result;
    }

    private boolean[] allZero(int[][] grid) {
        int one = 0;
        int zero = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    one++;
                } else {
                    zero++;
                }
            }
        }
        if (zero == 0) return new boolean[]{false, true};
        if (one == 0) return new boolean[]{true, false};
        return new boolean[]{false, false};
    }

    private void dfs(int[][] grid, int i, int j) {
        visited[i][j] = true;
        count++;
        for (int k = 0; k < dic.length; k++) {
            int n_i = i + dic[k][0];
            int n_j = j + dic[k][1];
            if (n_i > grid.length - 1 || n_i < 0 || n_j < 0 || n_j > grid[0].length - 1
                    || visited[n_i][n_j] || grid[n_i][n_j] == 0) {
                continue;
            }
            dfs(grid, n_i, n_j);
        }
    }

    private void clear(boolean[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], false);
        }
    }
}
