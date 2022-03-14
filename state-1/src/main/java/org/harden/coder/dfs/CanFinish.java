package org.harden.coder.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/13 22:22
 * 文件说明： 207. 课程表</p>
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 
 * prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanFinish {

    private List<Integer>[] graph;

    private int[] bit;

    /**
     * 判断是否有环
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        init(numCourses, prerequisites);
        Queue<Integer> path = new ArrayDeque<>();
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] == 0) {
                path.offer(i);
                count++;
            }
        }
        while (!path.isEmpty()) {
            int isZero = path.poll();
            //在这行里 剔除相关联的元素分别-1
            for (int i = 0; i < graph[isZero].size(); i++) {
                Integer index = graph[isZero].get(i);
                bit[index]--;
                if (bit[index] == 0) {
                    path.offer(index);
                    count++;
                }
            }
        }
        return count == numCourses;
    }

    private void init(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        bit = new int[numCourses];
        int k = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            int w = prerequisites[i][0];
            int h = prerequisites[i][1];
            //应该采用无向图
            graph[w].add(h);
            graph[h].add(w);
            bit[w] = bit[w] + 1;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1},{1,0}};
        CanFinish canFinish = new CanFinish();
        System.out.println(canFinish.canFinish(2, graph));
    }
}
