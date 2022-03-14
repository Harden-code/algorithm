package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 21:31
 * 文件说明： 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * </p>
 */
public class InorderTraversal {
    private List<Integer> list=new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        reserve(root);
        return list;
    }

    public void reserve(TreeNode root){
        if(root==null){
            return;
        }
        reserve(root.left);
        list.add(root.val);
        reserve(root.right);
    }
}
