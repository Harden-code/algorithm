package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/8 18:10
 * 文件说明：
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * </p>
 */
public class IsBalanced {

    private boolean flag=true;
    /**
     * 计算左节点和右节点的差不能小于1
     * 转换成求两边深度相减
     */
    public boolean isBalanced(TreeNode root) {
        reserve(root);
        //前序遍历
        return flag;
    }

    //求最大深度

    public int reserve(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=reserve(root.left);
        int right=reserve(root.right);
        if(Math.abs(left-right)>1){
            flag=false;
        }
        //从下开始加
        return Math.max(left,right)+1;
    }
}
