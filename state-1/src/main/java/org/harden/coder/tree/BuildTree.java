package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/13 0:08
 * 文件说明：105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *
 * </p>
 */
public class BuildTree {
    /**
     * 在前序遍历的第一个元素为 root，在通过root在中序遍历中找左右子节点
     * @param preorder 前序
     * @param inorder 中序
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reserve(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    //保持preorder inorder的子树个数相同
    public TreeNode reserve(int[] preorder,int i,int j, int[] inorder,int p,int q){
        if(i>j){
            return null;
        }
        //前序遍历 第一个是头节点，通过左右树构建root
        TreeNode root=new TreeNode(preorder[i]);
        //从中序 所有左节点长度
        int l=p;
        while (preorder[i]!=inorder[l]){
            l++;
        }
        int leftSize=l-p;
        //从左子树 前序 [i+1,i+leftSize] 左子start  [p,l-1] l-1是左节点个数
        TreeNode left = reserve(preorder, i+1, i+leftSize, inorder, p, l-1);
        //[i+leftSize+1,j] 右子树
        TreeNode right = reserve(preorder, i+leftSize+1, j, inorder, l+1, q);
        root.right=right;
        root.left=left;
        return root;
    }

}
