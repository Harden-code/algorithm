package org.harden.coder.hash;

import org.harden.coder.link.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 15:17
 * 文件说明：
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * </p>
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        //构造虚拟头节点
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null) {
            //判断是否有重复 有就删除
            if (set.contains(p.next.val)) {
                p.next = p.next.next;
                continue;
            }
            set.add(p.next.val);
            p = p.next;
        }
        return newHead.next;
    }
}
