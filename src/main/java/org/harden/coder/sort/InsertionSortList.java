package org.harden.coder.sort;

import org.harden.coder.link.ListNode;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 17:41
 * 文件说明： 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        while (p != null) {
            ListNode q = newHead;
            ListNode temp = p.next;
            //移动下标 找到前节点
            while (q.next != null && q.next.val <= p.val) {
                q=q.next;
            }
            p.next=q.next;
            q.next=p;
            p = temp;
        }
        return newHead.next;
    }
}
