package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/8 18:36
 * 文件说明：226. 翻转二叉树
 * <p>
 *   4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 *   4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * </p>
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //父问题-左节点跟右节点转换 子问题相同
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        queue.add(list);
        while (!queue.isEmpty()) {
            List<TreeNode> poll = queue.poll();
            int i = 0;
            int j = poll.size() - 1;
            //交换
            while (i < j) {
                TreeNode left = poll.get(i++);
                TreeNode right = poll.get(j--);
                if (left == null || right == null) {
                    continue;
                }

                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            }
            List<TreeNode> temp = new ArrayList<>();
            for (int k = 0; k < poll.size(); k++) {
                if (poll.get(k) == null) {
                    continue;
                }
                if (poll.get(k).left != null && poll.get(k).right != null) {
                    temp.add(poll.get(k).left);
                    temp.add(poll.get(k).right);
                } else if (poll.get(k).left == null && poll.get(poll.size()-1-k) != null) {
                    //左边为空,右边不为空 对称边
                    poll.get(k).left=poll.get(poll.size()-1-k).right;
                    poll.get(k).right=null;
                    temp.add(poll.get(k).left);
                    temp.add(null);
                } else if (poll.get(poll.size()-1-k) != null && poll.get(k).right == null) {
                    //右边为空
                    poll.get(k).right=poll.get(poll.size()-1-k).left;
                    poll.get(k).left=null;
                    temp.add(null);
                    temp.add(poll.get(k).right);
                }

            }
            if (!temp.isEmpty()) {
                queue.add(temp);
            }

        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode left3 = new TreeNode(1, null, null);
//        TreeNode right3 = new TreeNode(2, null, null);
//
//        TreeNode left2 = new TreeNode(3, null, null);
//        TreeNode right2 = new TreeNode(4, null, null);
//
//        TreeNode right1 = new TreeNode(20, left2, right2);
//
//        TreeNode left1 = new TreeNode(9, left3, right3);
//
//
//        TreeNode root = new TreeNode(3, left1, right1);

        TreeNode left3 = new TreeNode(1, null, null);
        TreeNode left1 = new TreeNode(9, left3, null);
        TreeNode root = new TreeNode(3, left1, null);



        InvertTree levelOrder2 = new InvertTree();
        levelOrder2.invertTree1(root);
    }
}
