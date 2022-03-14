package org.harden.coder.dfs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/10 22:14
 * 文件说明：面试题 04.01. 节点间通路 </p>
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWhetherExistsPath {
    private boolean check = false;

    private boolean[] visit;

    private Set<Integer>[] standardGraph;


    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        visit = new boolean[n];
        newGraph(graph,n);

        dfs(start,target);

        return check;
    }

    /**
     * 重复的不是相反
     * @param graph
     * @param n
     */
    public void newGraph(int[][] graph, int n) {
        standardGraph = new HashSet[n];
        for (int i = 0; i < graph.length; i++) {
            int i1 = graph[i][0];
            int i2 = graph[i][1];
            Set<Integer> state = standardGraph[i1];
            if (Objects.nonNull(state)) {
                state.add(i2);
            } else {
                HashSet<Integer> list = new HashSet<>();
                list.add(i2);
                standardGraph[i1] = list;
            }
        }
    }
    //找路径
    public void dfs(int start, int target) {
        visit[start]=true;
        Set<Integer> set = standardGraph[start];

        if(start==target){
            check=true;
            return;
        }

        if(Objects.isNull(set)){
            return;
        }
        for (Integer integer : set) {
            if(visit[integer]){
                continue;
            }
            dfs(integer,target);
        }
    }

    public static void main(String[] args) {
        FindWhetherExistsPath findWhetherExistsPath = new FindWhetherExistsPath();
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};

        int[][] graph1={{0, 1},{1, 2},{1, 3},{1, 10}, {1, 11},{1, 4}
        , {2, 4},{2, 6}, {2, 9}, {2, 10}
        , {2, 4}, {2, 5}, {2, 10}, {3, 7}, {3, 7}, {4, 5}
        ,{4, 11},{4, 11},{4, 10},{ 5, 7},{ 5, 10}, {6, 8}, {7, 11}, {8, 10}};
//        findWhetherExistsPath.newGraph(graph,12);
        System.out.println(findWhetherExistsPath.findWhetherExistsPath(12, graph, 0, 2));
    }
}
