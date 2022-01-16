package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 21:26
 * 文件说明：
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * </p>
 */
public class PreorderTraversal {
    private List<Integer> list=new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        reserve(root);
        return list;
    }

    public void reserve(TreeNode root){
        //终止条件
        if(root==null){
            return;
        }
        list.add(root.val);
        reserve(root.left);
        reserve(root.right);
    }
}
