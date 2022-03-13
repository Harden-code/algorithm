package org.harden.coder.recursion;

import org.harden.coder.link.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/21 21:34
 * 文件说明：
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * </p>
 */
public class ReversePrint {

    private List<Integer> list=new ArrayList<>();

    public int[] reversePrint(ListNode head) {
         reverse(head);
        int[] ints = new int[list.size()];
        for(int i=0;i<ints.length;i++){
            ints[i]=list.get(i);
        }
        return ints;
    }

    public void reverse(ListNode head){
        if(head==null){
            return;
        }
        reverse(head.next);
        list.add(head.val);
    }

    public static void main(String[] args) {
        ReversePrint reversePrint = new ReversePrint();
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        reversePrint.reverse(node3);
    }
}
