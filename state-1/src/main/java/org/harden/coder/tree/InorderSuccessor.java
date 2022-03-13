package org.harden.coder.tree;

import org.harden.coder.TreeNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/9 19:14
 * 文件说明：面试题 04.06. 后继者
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。</p>
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 * 输出 2
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class InorderSuccessor {
    private TreeNode target=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        reserve(root,p);
        return target;
    }

    public void reserve(TreeNode root,TreeNode p){

        if(root==null){
            return;
        }
        if(target!=null){
            return;
        }
        inorderSuccessor(root.left,p);
        if(root.val==p.val){
            target=root;
        }
        inorderSuccessor(root.right,p);

    }
}
