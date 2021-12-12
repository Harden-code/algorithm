package org.harden.coder.link;

import java.util.HashMap;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/6 22:19
 * 文件说明：
 * 存在一个按升序排列的链表，给你这个链表的头节点 head
 * ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //头节点
        ListNode p = head;
        ListNode temp = head;
        while (p.next!=null){
            if(p.val==p.next.val){
                p.next=p.next.next;
            }else {
                p=p.next;
            }

        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(4, node2);

        deleteDuplicates(node1);

    }
}
