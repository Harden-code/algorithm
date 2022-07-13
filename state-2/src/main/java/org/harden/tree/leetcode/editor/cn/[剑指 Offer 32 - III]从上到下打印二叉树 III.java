//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 229 👎 0

package org.harden.tree.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author junsenfu
 * @date 2022-05-29 19:42:44
 */
class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();

        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(20,treeNode4,treeNode5);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode1 = new TreeNode(3,treeNode2,treeNode3);
        System.out.println(solution.levelOrder(treeNode1).toString());
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root == null) {
                return result;
            }
            queue.add(root);
            //add 已经加入
            int c = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int[] arr=new int[size];
                if(((c&1)==0)){
                    for (int i = size; i > 0; i--) {
                        //奇数
                        TreeNode poll = queue.poll();
                        if(poll.left!=null){
                            queue.offer(poll.left);
                        }
                        if(poll.right!=null){
                            queue.offer(poll.right);
                        }

                        arr[i-1]=poll.val;
                    }
                }else {
                    for (int i = 0; i < size; i++) {
                        TreeNode poll = queue.poll();
                        if(poll.left!=null){
                            queue.offer(poll.left);
                        }
                        if(poll.right!=null){
                            queue.offer(poll.right);
                        }
                        //偶数
                        arr[i]=poll.val;
                    }
                }
                List<Integer> collect = Arrays.stream(arr).boxed()
                        .collect(Collectors.toList());
                c++;
                result.add(collect);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}