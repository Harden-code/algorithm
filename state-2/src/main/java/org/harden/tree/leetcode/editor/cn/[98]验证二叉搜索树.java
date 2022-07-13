//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1596 👎 0

package org.harden.tree.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-05-26 20:40:09
 */
class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(5,treeNode5,treeNode7);
        TreeNode treeNode2 = new TreeNode(1,treeNode4,treeNode5);
        TreeNode treeNode1 = new TreeNode(3,treeNode2,treeNode3);
        System.out.println(solution.isValidBST(treeNode1));
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


        public boolean isValidBST(TreeNode root) {
            //1.利用中序遍历的有序性
            List<Integer> arrs = isValidBST_r(root, new ArrayList<>());
            for (int i = 1; i < arrs.size(); i++) {
                if (arrs.get(i)<=arrs.get(i-1)){
                    return false;
                }
            }
            return true;
        }

        private List<Integer> isValidBST_r(TreeNode root, List<Integer> arrs) {
            if (root == null) {
                return arrs;
            }
            isValidBST_r(root.left, arrs);
            arrs.add(root.val);
            isValidBST_r(root.right, arrs);
            return arrs;
        }
        private void isValidBST_r(TreeNode root) {
            if(root==null){
                return;
            }
            isValidBST_r(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}