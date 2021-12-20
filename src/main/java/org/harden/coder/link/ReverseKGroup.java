package org.harden.coder.link;

import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/12 17:49
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        //存头节点
        ListNode temp = head;
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        int i = 1;
        while (p != null) {
            ListNode h = p.next;
            if (i % k == 0) {
                p.next = null;
                ListNode reverse = reverse(temp);
                temp = h;
                tail.next = reverse;
                tail = findEnd(reverse);
            }
            i++;
            p = h;
        }
        tail.next = temp;

        return newHead.next;
    }

    public ListNode findEnd(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            //下一个节点
            ListNode temp = p.next;
            //反转
            p.next = prev;
            //记录头节点
            prev = p;
            p = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(node3, 2);
    }
}
