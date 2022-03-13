package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/11/16 20:25
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        //递归结束条件
        if(head ==null || head.next ==null){
            return head;
        }
        ListNode slow =head;
        ListNode fast =head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode tep=slow.next;
        //断开节点
        slow.next=null;
        ListNode left = sortList(head);
        ListNode right= sortList(tep);
        ListNode node =new ListNode(0);
        ListNode c=node;
        while(left!=null && right!=null){
            if(left.val<right.val){
                node.next=left;
                left=left.next;
            }else {
                node.next=right;
                right=right.next;
            }
            node=node.next;
        }
        node.next=left!=null?left:right;
        return c.next;
    }
}
