package org.harden.coder.tree;

import org.harden.coder.link.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/16 15:26
 * 文件说明： 23. 合并K个升序链表</p>
 */
public class MergeKLists {
    class Node {
        ListNode cur;
        int num;

        Node(ListNode listNode) {
            this.cur = listNode;
            this.num = listNode.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        //使用小顶堆，让节点
        Queue<Node> queue = new PriorityQueue<>(lists.length,
                (n1, n2) -> n1.num - n2.num);
        //先放入堆
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                queue.offer(new Node(node));
            }
        }

        while (!queue.isEmpty()) {
            //弹出堆顶元素
            ListNode poll = queue.poll().cur;
            tail.next = poll;
            tail = poll;
            //放入下一个元素
            ListNode next = poll.next;
            if (next != null) {
                Node node = new Node(next);
                queue.offer(node);
            }
        }
        return head.next;
    }
}
