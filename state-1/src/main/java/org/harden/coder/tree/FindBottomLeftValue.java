package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/5 22:18
 * 文件说明： 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 * 假设二叉树中至少有一个节点。
 * </p>
 */
public class FindBottomLeftValue {
    private int deep=0;

    private int result=0;

    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return 0;
        }
        reserve(root,0);
        return result;
    }

    public void reserve(TreeNode root,int k){
        //k 用来记录深度
        if(root==null){
            return ;
        }
        k++;
        reserve(root.left,k);
        if(k>deep){
            deep=k;
            result=root.val;
        }
        reserve(root.right,k);
    }
}
