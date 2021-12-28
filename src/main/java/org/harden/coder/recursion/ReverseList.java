package org.harden.coder.recursion;

import org.harden.coder.link.ListNode;

import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/21 21:50
 * 文件说明： </p>
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head){
        //1 返回
        if(head.next==null){
            return head;
        }
        ListNode reverse = reverse(head.next);
        //5,4,3,2,1
        //2 的下一个是元素的下一个值是 head
        head.next.next=head;
        //取消2->1
        head.next=null;
        return reverse;
    }
    public ListNode reverseList1(ListNode head) {
        ListNode h=head;
        ListNode pre=null;
        while (h!=null){
            ListNode n=h.next;
            h.next=pre;
            pre=h;
            h=n;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ReverseList reverseList = new ReverseList();
        ListNode node = reverseList.reverseList(node3);
        System.out.println("");
    }
}
