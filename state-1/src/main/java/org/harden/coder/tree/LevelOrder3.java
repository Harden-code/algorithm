package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 22:46
 * 文件说明： 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
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
public class LevelOrder3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if(root==null){
            return all;
        }
        //用来存放每一层所有节点
        Queue<List<TreeNode>> listQueue = new ArrayDeque<>();

        List<TreeNode> roots = new ArrayList<>();

        roots.add(root);
        listQueue.add(roots);
        int j=1;
        while (!listQueue.isEmpty()) {

            //用来存储下层节点
            List<TreeNode> temp = new ArrayList<>();
            //用来存储节点的值
            List<Integer> list = new ArrayList<>();

            List<TreeNode> poll = listQueue.poll();


            //循环遍历队列头部的一层的节点
            if(j%2!=0){
                for (int i = 0; i < poll.size(); i++) {
                    list.add(poll.get(i).val);
                    if (poll.get(i).left != null) {
                        temp.add(poll.get(i).left);
                    }
                    if (poll.get(i).right != null) {
                        temp.add(poll.get(i).right);
                    }

                }
            }else {
                //获取顺序不同
                for(int k=poll.size()-1;k>=0;k--){
                    list.add(poll.get(k).val);
                }
                for (int i = 0; i < poll.size(); i++) {
                    if (poll.get(i).left != null) {
                        temp.add(poll.get(i).left);
                    }
                    if (poll.get(i).right != null) {
                        temp.add(poll.get(i).right);
                    }
                }

            }
            if (temp.size() != 0) {
                listQueue.add(temp);
            }
            if (list.size() != 0) {
                all.add(list);
            }
            j++;
        }
        return all;
    }

    public static void main(String[] args) {
        System.out.println(0%2);
        TreeNode left1 = new TreeNode(5,null,null);
        TreeNode left2 = new TreeNode(4,null,null);
        TreeNode right2 = new TreeNode(3,null,left1);
        TreeNode right1 = new TreeNode(2,left2,null);

        TreeNode root = new TreeNode(1,right1,right2);

        LevelOrder3 levelOrder2 = new LevelOrder3();
        levelOrder2.levelOrder(root);
    }
}
