package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 22:15
 * 文件说明： 102. 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * </p>
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if(root==null){
            return all;
        }
        //存储一层的节点
        Queue<List<TreeNode>> queue = new LinkedList<>();

        List<TreeNode> roots = new ArrayList<>();
        roots.add(root);

        queue.add(roots);
        while (queue.size() != 0) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> poll = queue.poll();
            List<TreeNode> temp = new ArrayList<>();
            for (int i = 0; i < poll.size(); i++) {
                list.add(poll.get(i).val);
                if (poll.get(i).left != null) {
                    temp.add(poll.get(i).left);
                }
                if (poll.get(i).right != null) {
                    temp.add(poll.get(i).right);
                }
            }
            if(list.size()!=0){
                all.add(list);
            }
            if(temp.size()!=0){
                queue.add(temp);
            }
        }
        return all;
    }

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(9,null,null);
        TreeNode left2 = new TreeNode(15,null,null);
        TreeNode right2 = new TreeNode(7,null,null);
        TreeNode right1 = new TreeNode(20,left2,right2);

        TreeNode root = new TreeNode(3,left1,right1);

        LevelOrder2 levelOrder2 = new LevelOrder2();
        levelOrder2.levelOrder(root);
    }
}
