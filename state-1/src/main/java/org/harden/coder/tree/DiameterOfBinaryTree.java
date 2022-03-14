package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/15 22:55
 * 文件说明：543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * </p>
 */
public class DiameterOfBinaryTree {
    private int max=0;

    /**
     * 求左右子节点的最长路径的和
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        System.out.println(left+" "+right);
        max=Math.max(max,left+right);

        //求一边的最长长度
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2,node1,node3);

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4,node2,node5);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        diameterOfBinaryTree.diameterOfBinaryTree(node4);
    }
}
