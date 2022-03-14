package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/7 21:41
 * 文件说明： 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5,
 * 以及 ans.next.next.next = NULL.
 *
 */
public class MiddleNode {
    //1.计算长度 基数 n/2+1 偶数 n/2+1
    //快慢指针
    public static ListNode middleNode(ListNode head) {
        if(head==null) {
            return null;
        }
        //慢指针
        ListNode s=head;
        ListNode f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return  s;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1, node2);
        middleNode(node1);

    }
}
