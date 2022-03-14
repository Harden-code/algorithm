package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/10 16:02
 * 文件说明：剑指 Offer II 052. 展平二叉搜索树
 *
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * </p>
 */
public class IncreasingBST {
    private TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        //新建一个节点
        TreeNode node = new TreeNode(-1);
        pre=node;
        reserve(root);
        return node.right;
    }

    public void reserve(TreeNode root){
        if(root==null){
            return ;
        }
        reserve(root.left);
        pre.right=root;
        root.left=null;
        pre=root;

        reserve(root.right);
    }

}
