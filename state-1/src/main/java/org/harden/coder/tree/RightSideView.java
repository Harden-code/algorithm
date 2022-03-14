package org.harden.coder.tree;

import org.harden.coder.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/10 17:28
 * 文件说明：
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * </p>
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        //找层最右边元素
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<List<TreeNode>> queue=new ArrayDeque<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        queue.add(treeNodes);
        while (!queue.isEmpty()){
            List<TreeNode> poll = queue.poll();
            if(!poll.isEmpty()){
                list.add(poll.get(0).val);
            }
            List<TreeNode> temp=new ArrayList<>();
            for(int i=0;i<poll.size();i++){
                TreeNode right = poll.get(i).right;
                TreeNode left = poll.get(i).left;
                if(right!=null){
                    temp.add(right);
                }
                if(left!=null){
                    temp.add(left);
                }
            }
            if(!temp.isEmpty()){
                queue.add(temp);
            }
        }
        return list;
    }


}
