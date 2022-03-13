package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/12 15:31
 * 文件说明：删除链表的倒数第 N 个结点
 *  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *  </p>
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) {
            return null;
        }
        ListNode p1=head;
        ListNode p2=head;
        int len=0;
        //先计算长度
        while(p1!=null){
            len++;
            p1=p1.next;
        }
        //删除节点下标
        int i =len-n;
        //遍历下标
        int j=1;
        //全删
        ListNode newHead=new ListNode();
        newHead.next=head;
        while(p2!=null){
            //删除中间删除
            if(j==i){

                //删除节点
                p2.next=p2.next.next;
                break;
            //头删 特殊情况  [1] 1
            }else if(i==0){
                newHead.next=p2.next;
                break;
            }
            j++;
            p2=p2.next;
        }
        return newHead.next;

    }
}
