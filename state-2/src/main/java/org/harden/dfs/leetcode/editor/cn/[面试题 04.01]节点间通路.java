//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
//
// 示例1: 
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
// 
//
// 示例2: 
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
// 
//
// 提示： 
//
// 
// 节点数量n在[0, 1e5]范围内。 
// 节点编号大于等于 0 小于 n。 
// 图中可能存在自环和平行边。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 👍 63 👎 0

package org.harden.dfs.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-07-12 22:52:51
 */
class RouteBetweenNodesLcci {
    public static void main(String[] args) {
        Solution solution = new RouteBetweenNodesLcci().new Solution();
        int[][] path = {{0, 2}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
//        solution.graph(path, 3);
        solution.findWhetherExistsPath(5, path, 0, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean result = false;
        private boolean[] visited;

        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            //图上查找
            visited = new boolean[n];
            List<Integer>[] new_graph = graph(graph, n);
            dfs(new_graph,start,target);
            return result;
        }

        private void dfs(List<Integer>[] new_graph, int s, int t) {
            visited[s] = true;
            if (s == t) {
                result = true;
                return;
            }
            for (int i = 0; i < new_graph[s].size(); i++) {
                int visit=new_graph[s].get(i);
                if (!visited[visit]) {
                    dfs(new_graph, visit, t);
                }
            }
        }


        private List<Integer>[] graph(int[][] path, int n) {
            List[] new_graph = new ArrayList[n];
            for (int i = 0; i < new_graph.length; i++) {
                new_graph[i]=new ArrayList();
            }
            for (int i = 0; i < path.length; i++) {
                int q = path[i][0];
                int p = path[i][1];
                if(!new_graph[q].contains(p)){
                    new_graph[q].add(p);
                }

            }
            return new_graph;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}