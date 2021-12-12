package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/8 22:48
 * 文件说明：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class GetIntersectionNode {
    /**
     * a+b =b+a 相交
     * a遍历直到尾部，然后在指向b，b遍历反之
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        //只做一次转换
        boolean flagA = true;
        boolean flagB = true;
        while (a != b) {
            if (a == null && flagA) {
                flagA = false;
                a = headB;
                //转换后不应该移动，移动a+b的总路径就不一样
                continue;
            }
            if (b == null && flagB) {
                flagB = false;
                b = headA;
                continue;
            }
            a = a.next;
            b = b.next;
        }
        return a;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode p1 = reverse(headA);
//        ListNode p2 = reverse(headB);
//        //记录前一个节点
//        ListNode prev = new ListNode();
//        while (p1 != null && p2 != null) {
//            if (p1.val == p2.val) {
//                prev=p1;
//            }else {
//
//                break;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//
//        return prev;
//    }

    public ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = prev;
            //设置头
            prev = p;
            //移动下标
            p = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node8 = new ListNode(1);
        ListNode node7 = new ListNode(2, node8);
        ListNode node6 = new ListNode(3, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(6, node4);


        ListNode node81 = new ListNode(1);
        ListNode node71 = new ListNode(2, node81);
        ListNode node61 = new ListNode(9, node71);
        ListNode node51 = new ListNode(9, node61);
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        getIntersectionNode.getIntersectionNode(node3, node51);
    }
}
