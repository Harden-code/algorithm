package org.harden.coder.dfs;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/10 21:08
 * 文件说明：剑指 Offer 13. 机器人的运动范围 </p>
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0]
 * 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位
 * 之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */
public class MovingCount {
    private int count = 0;
    /**
     * 运行方向
     */
    private int[][] dic = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean[][] visit;

    public int movingCount(int m, int n, int k) {
        if (k == 0 || m == 0) {
            return 0;
        }
        visit = new boolean[m][n];
        dfs(m, n, k, 0, 0);
        return count;
    }

    public void dfs(int m, int n, int k, int i, int j) {
        //记录访问
        visit[i][j] = true;
        //只要一进入，就是条件符合的
        count++;
        for (int p = 0; p < dic.length; p++) {

            int newI = dic[p][0] + i;
            int newJ = dic[p][1] + j;
            //取反条件，取正条件 逻辑比较复杂
            if (newI < 0 || newJ <0 || newI >= m || newJ >= n ||
                    !check(newI, newJ, k) || visit[newI][newJ]) {
                continue;
            }
            dfs(m, n, k, newI, newJ);
        }
    }

    public static boolean check(int m, int n, int k) {
        int target = 0;
        while (m != 0) {
            target += m % 10;
            m = m / 10;
        }
        while (n != 0) {
            target += n % 10;
            n = n / 10;
        }
        return target <= k;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(1, 2, 1));
    }
}
