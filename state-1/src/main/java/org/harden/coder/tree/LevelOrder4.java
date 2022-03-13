package org.harden.coder.tree;

import org.harden.coder.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/5 22:22
 * 文件说明： 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * </p>
 */
public class LevelOrder4 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> all=new ArrayList<>();
        if(root==null){
            return all;
        }

        Queue<List<Node>> queue=new ArrayDeque<>();
        List<Node> roots=new ArrayList<>();
        roots.add(root);
        queue.add(roots);

        while (queue.size()!=0){
            List<Node> poll = queue.poll();
            List<Node> temp=new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<poll.size();i++){
                list.add(poll.get(i).val);
                temp.addAll(poll.get(i).children);
            }

            if(temp.size()!=0){
                queue.add(temp);
            }
            if(list.size()!=0){
                all.add(list);
            }
        }
        return all;
    }
}
