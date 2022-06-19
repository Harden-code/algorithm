//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1635 👎 0

package org.harden.tree.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-06-15 21:39:27
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
//        int[] pre={ 3,9,20,15,7};
//        int[] in={9,3,15,20,7};
        int[] pre={ 1,2};
        int[] in={2,1};
        solution.buildTree(pre,in);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return built(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }


        private TreeNode built(int[] preorder, int i, int j, int[] inorder, int p, int q) {
            if (i > j) {
                //[1,2] 直接空  new TreeNode(preorder[i]); i + leftIndex + 1
                return null;
            }
            //前序遍历 第一个节点就是 头节点
            TreeNode root = new TreeNode(preorder[i]);
            //在中序遍历中找到左子树 和 右子树
            int k = p;
            while (k <= q && inorder[k] != preorder[i]) {
                k++;
            }
            //k-p 左边长
            int leftIndex = k-p;
            //构建左树
            TreeNode left = built(preorder, i + 1, i + leftIndex, inorder, p, k - 1);
            //构建右树
            TreeNode right = built(preorder, i + leftIndex + 1, j, inorder, k + 1, q);
            root.left = left;
            root.right = right;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}