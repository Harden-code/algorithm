//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 链表 二叉树 👍 75 👎 0

package org.harden.tree.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-06-19 22:20:05
 */
class ListOfDepthLcci {
    public static void main(String[] args) {
        Solution solution = new ListOfDepthLcci().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        private List<ListNode> nodes=new ArrayList<>();
        public ListNode[] listOfDepth(TreeNode tree) {
            dfs(tree,1);
            ListNode[] result=new ListNode[nodes.size()];
            for (int i = 0; i < nodes.size(); i++) {
                result[i]=nodes.get(i);
            }
            return result;
        }

        private void dfs(TreeNode treeNode,int k){
            if(treeNode==null){
                return;
            }
            if(nodes.size()<k){
                nodes.add(new ListNode(treeNode.val));
            } else {
                ListNode listNode = nodes.get(k-1);
                ListNode temp=listNode;
                while (temp.next!=null){
                    temp=temp.next;
                }
                temp.next=new ListNode(treeNode.val);
            }
            dfs(treeNode.left,k+1);
            dfs(treeNode.right,k+1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}