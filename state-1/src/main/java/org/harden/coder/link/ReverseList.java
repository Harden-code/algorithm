package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/7 12:56
 * 文件说明：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p=head;
        ListNode prev=null;
        //从第一个节点开始遍历
        while (p!=null){
            //保存下一个节点，也是反转的上一个节点
            ListNode temp=p.next;
            p.next=prev;
            //记录头节点
            prev=p;
            //移动
            p=temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);
        reverseList(node1);

    }
}
