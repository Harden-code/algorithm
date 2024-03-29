package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/12 15:17
 * 文件说明：
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 *
 * 思路2 使用两个节点，让两个节点的差距拉成k的距离
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //第一次遍历指针
        ListNode p1 = head;
        //第二次遍历指针
        ListNode p2 = head;
        int len = 0;
        while (p1 != null) {
            len++;
            p1 = p1.next;
        }
        int i = len - k;
        int j = 0;
        while (p2 != null) {
            if (j == i) {
                break;
            }
            p2 = p2.next;
            j++;
        }
        return p2;
    }
}
