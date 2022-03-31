package org.harden.coder.dfs;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/3/17 11:26
 * 文件说明： LCP 07. 传递信息</p>
 * <p>
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，
 * 分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumWays {
    private int result = 0;


    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> graph = graph(n, relation);
        dfs(graph, 0, k, 0, n - 1);
        return result;
    }

    public List<List<Integer>> graph(int n, int[][] relation) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < relation.length; i++) {
            int p = relation[i][0];
            int q = relation[i][1];
            List<Integer> list = graph.get(p);
            if (!list.contains(q)) {
                list.add(q);
            }
        }
        return graph;
    }

    /**
     * [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]
     * 0: 2 4
     * 1: 4
     * 2: 1 3 0
     * 3: 4
     * 4:
     */
    public void dfs(List<List<Integer>> graph, int l, int k, int source, int target) {
        if (l == k) {
            if (source == target) {
                result++;
            }
            return;
        }
        List<Integer> list = graph.get(source);
        for (int i = 0; i < list.size(); i++) {
            dfs(graph, l + 1, k, list.get(i), target);
        }
    }

    public static void main(String[] args) {
        int[][] d = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        NumWays numWays = new NumWays();
        numWays.numWays(5, d, 3);
    }
}
