package org.harden.coder.tree;

import org.harden.coder.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 21:45
 * 文件说明：
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * </p>
 */
public class Preorder {
    private List<Integer> list=new ArrayList<>();

    public List<Integer> preorder(Node root) {
        reverse(root);
        return list;
    }

    public void reverse(Node root){
        if(root==null){
            return;
        }
        list.add(root.val);
        for(int i=0;i<root.children.size();i++){
            reverse(root.children.get(i));
        }
    }

}
