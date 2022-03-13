package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/7 21:53
 * 文件说明： 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 输入：head = [1,2]
 * 输出：false
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return false;
        }
        //先找到中间节点
        ListNode p=head;
        ListNode middle = findMiddle(head);
        //
        ListNode temp=middle;
        ListNode sort = reverser(temp);
        while (sort!=null){
            if(p.val!=sort.val){
                return false;
            }
            p=p.next;
            sort=sort.next;
        }
        //反转截取
        return true;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        //fast==null 偶数 fast.next==null 奇数
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverser(ListNode head){
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode p=head;
        while (p!=null){
            ListNode temp=p.next;
            //指针移动 1->3  3<-1
            p.next=prev;
            prev=p;
            //移动下标
            p=temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1, node2);
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(node1));
    }

}
