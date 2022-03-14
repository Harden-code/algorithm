package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/8 21:35
 * 文件说明：两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * </p>
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        //进位
        int set = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            int i = p1.val;
            int j = p2.val;
            int sum = i + j;
            if (set > 0) {
                //进位
                sum = sum + set;
                set = 0;
            }

            if (sum >= 10) {
                //求余数
                sum = sum % 10;
                set = 1;
            }
            ListNode node = new ListNode(sum);
            tail.next = node;
            tail = node;
            //移动下标
            p1 = p1.next;
            p2 = p2.next;
        }
        //有进位 p1还剩的
        while (p1 != null) {
            int i = p1.val;
            if (set > 0) {
                i = i + 1;
                set = 0;
            }
            if (i >= 10) {
                i = i % 10;
                set = 1;
            }
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
            p1 = p1.next;
        }
        while (p2 != null) {
            int i = p2.val;
            if (set >0) {
                i = i + 1;
                set = 0;
            }
            if (i >= 10) {
                i = i % 10;
                set = 1;
            }
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
            p2 = p2.next;
        }
        //在判断进位
            if(set>0){
                ListNode node = new ListNode(1);
                tail.next=node;
            }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node8 = new ListNode(9);
        ListNode node7 = new ListNode(9,node8);
        ListNode node6 = new ListNode(9,node7);
        ListNode node5 = new ListNode(9, node6);
        ListNode node4 = new ListNode(9,node5);
        ListNode node3 = new ListNode(9,node4);


        ListNode node81 = new ListNode(9);
        ListNode node71 = new ListNode(9,node81);
        ListNode node61 = new ListNode(9,node71);
        ListNode node51 = new ListNode(9, node61);

        addTwoNumbers(node3,node51);
    }
}
