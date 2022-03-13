package org.harden.coder.sort;

import org.harden.coder.link.ListNode;


/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 16:19
 * 文件说明： </p>
 */
public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode p = head;

        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        while (p != null) {
            ListNode t=p.next;
            ListNode q =newHead;
            while (q.next != null &&q.next.val<=p.val ) {
                q = q.next;
            }
            p.next=q.next;
            q.next=p;
            p = t;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(4, node2);
        sortList(node1);
    }
}
