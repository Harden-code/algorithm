//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 👍 1570 👎 0

package org.harden.link.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-04-04 18:23:15
 */
class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(1, node4);
        solution.reverseKGroup(node5, 2);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode h = head;
            //反转头
            ListNode p = head;

            ListNode newHead=new ListNode();
            ListNode tail=newHead;
            int i = 1;
            while (h != null) {
                ListNode temp = h.next;
                if (i % k == 0) {
                    //断开
                    h.next=null;
                    //反转
                    ListNode pre = null;
                    while (p != null) {
                        ListNode t = p.next;
                        p.next = pre;
                        pre = p;
                        p = t;
                    }
                    tail.next=pre;
                    ListNode end = pre;
                    while (end.next != null) {
                        end = end.next;
                    }
                    //连接到新节点上
                    tail=end;
                    p = temp;
                }
                //剩余节点
                if(p!=null){
                    tail.next=p;
                }
                i++;
                h = temp;
            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}