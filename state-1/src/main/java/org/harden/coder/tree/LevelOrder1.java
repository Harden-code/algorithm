package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 22:00
 * 文件说明：剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * [3,9,20,15,7]
 *
 * </p>
 */
public class LevelOrder1 {



    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        //使用队列先把放入左节点，再放右节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size()!=0) {
            TreeNode poll=queue.poll();
            list.add(poll.val);
            if(poll.left!=null){
                queue.add(poll.left);

            }
            if(poll.right!=null){
                queue.add(poll.right);
            }

        }
        int[] ints=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ints[i]=list.get(i);
        }

        return ints;
    }
}
