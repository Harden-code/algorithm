//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1611 👎 0

package org.harden.tree.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-06-06 22:32:47
 */
class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(-1);
        TreeNode treeNode1 = new TreeNode(-3, treeNode2, null);
        solution.maxPathSum(treeNode1);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root.left == null && root.right == null) {
                return root.val;
            }
            dfs(root);
            return max;
        }

        private int dfs(TreeNode root) {
            //求左树+右边+root的最大值
            if (root.left == null && root.right == null) {
                return root.val;
            }
            int left =-1001;
            int right = -1001;
            if (root.left != null) {
                left = dfs(root.left);
            }
            if (root.right != null) {
                right = dfs(root.right);
            }
            //负数情况
            int sum = left + right + root.val;
            int ret=-1001;
            if (left > 0 && right > 0 && root.val > 0) {
                max = Math.max(sum, max);
                ret=Math.max(left+root.val, right+root.val);
            } else {
                max = Math.max(sum, max);
                if(left!=1001){
                    max = Math.max(left + root.val, max);
                    ret=Math.max(left+root.val,ret);
                }
                if(right!=1001){
                    max = Math.max(right + root.val, max);
                    ret=Math.max(right+root.val,ret);
                }
                ret=Math.max(root.val,ret);
                max = Math.max(left, max);
                max = Math.max(right, max);
                max = Math.max(root.val, max);
            }
            return ret;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}