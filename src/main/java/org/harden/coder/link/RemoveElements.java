package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/7 12:23
 * 文件说明：
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足
 * Node.val == val 的节点，并返回 新的头节点 。
 *输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 输入：head = [], val = 1
 * 输出：[]
 */
public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }

        ListNode temp=new ListNode();
        temp.next=head;
        ListNode p=temp;
        //头节点判断
        while(p.next!=null){

            if(p.next.val==val){
                p.next=p.next.next;
            }else{
                p=p.next;
            }

        }
        return temp.next;
    }
}
