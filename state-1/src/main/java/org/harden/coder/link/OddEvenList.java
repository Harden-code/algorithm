package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/8 22:29
 * 文件说明： 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，
 * 时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        int i = 0;
        //偶数节点
        ListNode p1=head;
        //奇数数节点
        ListNode temp = head.next;
        ListNode p2=temp;

        while (p2!=null&&p2.next!=null){
            //1,2,3,4,5
            // 1-3
            p1.next=p2.next;
            // 3
            p1=p1.next;
            // 2-4
            p2.next=p1.next;
            //4
            p2=p2.next;

        }
        p1.next=temp;




        return head;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        oddEvenList(node3);
    }
}
