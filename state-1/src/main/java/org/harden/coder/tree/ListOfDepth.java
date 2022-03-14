package org.harden.coder.tree;

import org.harden.coder.link.ListNode;
import org.harden.coder.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/12 22:03
 * 文件说明：面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 * </p>
 */
public class ListOfDepth {

    private List<ListNode> list=new ArrayList<>();

    public ListNode[] listOfDepth(TreeNode tree) {
        dfs(tree,0);
        return list.toArray(new ListNode[list.size()]);
    }

    public TreeNode dfs(TreeNode tree,int i){
        if(tree==null){
            return null;
        }
        ListNode node = new ListNode(tree.val);
        if(list.size()<=i){
            list.add(i,node);
        }else {
            ListNode head = list.get(i);
            if(head!=null) {
                ListNode p = head;
                while (p.next != null) {
                    p = p.next;
                }
                p.next = node;
            }
        }
        i++;
        TreeNode left=dfs(tree.left,i);
        TreeNode right=dfs(tree.right,i);
        return tree;
    }

}
