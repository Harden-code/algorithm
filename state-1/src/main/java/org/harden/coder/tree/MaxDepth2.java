package org.harden.coder.tree;

import org.harden.coder.Node;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/8 17:50
 * 文件说明：
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class MaxDepth2 {

    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        //记录栈的深度
        int result=1;
        for(int i=0;i<root.children.size();i++){
            int i1 = maxDepth(root.children.get(i)) + 1;
            if(i1>result){
                result=i1;
            }
        }
        return result;
    }
}
