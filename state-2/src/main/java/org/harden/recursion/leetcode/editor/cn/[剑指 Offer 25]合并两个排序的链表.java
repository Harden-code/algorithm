//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 238 👎 0

package org.harden.recursion.leetcode.editor.cn;

import org.harden.link.leetcode.editor.cn.ListNode;

import java.util.List;

/**
 * @author junsenfu
 * @date 2022-04-23 23:16:28
 */
class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);

        ListNode node1_ = new ListNode(4);
        ListNode node2_ = new ListNode(3, node1_);
        ListNode node3_ = new ListNode(1, node2_);

        final ListNode listNode = solution.mergeTwoLists(node3, node3_);
        System.out.println();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        // 输入：1->2->4, 1->3->4
        //输出：1->1->2->3->4->4
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode tail = head;
            mergeTwoLists_r(l1, l2, tail);
            return head.next;
        }

        public void mergeTwoLists_r(ListNode l1, ListNode l2, ListNode tail) {
            if (l1 == null) {
                tail.next = l2;
                return;

            }
            if (l2 == null) {
                tail.next = l1;
                return;
            }
            int i1 = l1.val;
            int i2 = l2.val;
            if (i1 < i2) {
                //l1 移动
                ListNode t1 = l1.next;
                //断开连接
                l1.next = null;
                tail.next = l1;
                tail = tail.next;
                mergeTwoLists_r(t1, l2, tail);
            } else {
                ListNode t2 = l2.next;
                l2.next = null;
                tail.next = l2;
                tail = tail.next;
                mergeTwoLists_r(l1, t2, tail);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}