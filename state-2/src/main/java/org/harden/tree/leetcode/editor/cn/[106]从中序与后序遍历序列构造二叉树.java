//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 768 👎 0

package org.harden.tree.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-06-16 22:56:09
 */
class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] q = {9, 3, 15, 20, 7};
        int[] p = {9, 15, 7, 20, 3};
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        TreeNode treeNode = solution.buildTree(q, p);
        System.out.println();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return built(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode built(int[] postorder, int i, int j, int[] inorder, int p, int q) {
            //以找到root的为参考
            if (i > j) {
                return null;
            }
            //后续遍历的最后一个节点为 root
            TreeNode root = new TreeNode(postorder[j]);
            //在中序遍历上找左树
            int k = p;
            while (inorder[k] != postorder[j]) {
                k++;
            }
            int leftIndex = k - p ;
            TreeNode left = built(postorder, i, i+leftIndex-1, inorder, p, k-1);
            TreeNode right = built(postorder, i+leftIndex, j-1, inorder, k+ 1, q );
            root.left = left;
            root.right = right;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}