package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/7 21:12
 * 文件说明：
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode();
        //优化
        ListNode tail = newHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            //小的加入
            if (p1.val > p2.val) {
                tail.next=p2;
                //记录尾巴节点
                tail=p2;
                p2=p2.next;
                tail.next=null;
            }else{
                tail.next=p1;
                tail=p1;
                p1=p1.next;
                //清空尾巴节点
                tail.next=null;
            }
        }
        //此时不用管tail
        if(p1!=null){
            tail.next=p1;
        }
        if(p2!=null){
            tail.next=p2;
        }
        //虚拟节点下个
        return newHead.next;
    }
    public static void main(String[] args) {

        ListNode node2 = new ListNode(4);
        ListNode node1 = new ListNode(3, node2);


        ListNode node21 = new ListNode(2);
        ListNode node11 = new ListNode(1, node21);
        mergeTwoLists(node1,node11);

    }
}
