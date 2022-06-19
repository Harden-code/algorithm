//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 256 👎 0

package org.harden.tree.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-06-15 22:47:56
 */
class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        int[] pre = {1, 3, 2, 4};
        int[] in = {3, 4, 2, 1};
        TreeNode treeNode = solution.constructFromPrePost(pre, in);
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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return built(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode built(int[] preorder, int i, int j, int[] postorder, int p, int q) {
            if (i > j) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[i]);
            //通过后续遍历找右子树
            if (i == j) {
                return root;
            }

            //前序遍历i+1 是后续遍历的左子树头节点
            int l = p;
            while (l <= j && preorder[i + 1] != postorder[l]) {
                l++;
            }

            //左子树个数 +1 数组下标
            int leftIndex = l - p + 1;
            //构建左树
            TreeNode left = built(preorder, i + 1, i + leftIndex, postorder, p, l);
            //构建右树
            TreeNode right = built(preorder, i+leftIndex + 1, j, postorder, l + 1, q - 1);
            root.left = left;
            root.right = right;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}