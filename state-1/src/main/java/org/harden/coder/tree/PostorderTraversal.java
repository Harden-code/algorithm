package org.harden.coder.tree;


import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 21:35
 * 文件说明：
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * </p>
 */
public class PostorderTraversal {
    private List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        reserve(root);
        return list;
    }

    public void reserve(TreeNode root){
        if(root==null){
            return;
        }
        reserve(root.right);
        reserve(root.left);
        list.add(root.val);
    }
}
