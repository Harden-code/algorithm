package org.harden.coder.tree;

import org.harden.coder.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 21:56
 * 文件说明： 590. N 叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 *
 * </p>
 */
public class Postorder {

    private List<Integer> list=new ArrayList<>();

    public List<Integer> postorder(Node root) {
        reserve(root);
        return list;
    }

    public void reserve(Node root){
        if(root==null){
            return;
        }
        for(int i=0;i<root.children.size();i++){
            reserve(root.children.get(i));
        }
        list.add(root.val);
    }
}
