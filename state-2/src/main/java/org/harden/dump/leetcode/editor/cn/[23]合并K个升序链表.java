//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2016 👎 0

package org.harden.dump.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author junsenfu
 * @date 2022-06-22 21:30:57
 */
class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        private class Element {
            private ListNode head;

            Element(ListNode head) {
                this.head = head;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0){
                return null;
            }
            //利用小顶堆存放节点，每次循环完毕取出最小的节点放入队列
            //然后把当前节点向后面移动
            ListNode head = new ListNode();
            ListNode tail = head;
            PriorityQueue<Element> dump = new PriorityQueue<>((t1, t2) -> t1.head.val - t2.head.val);
            for (int i = 0; i < lists.length; i++) {
                ListNode h = lists[i];
                if(h==null){
                    continue;
                }
                dump.add(new Element(h));
            }
            while (!dump.isEmpty()) {
                Element poll = dump.poll();
                ListNode node = poll.head;
                ListNode next = node.next;
                tail.next = node;
                tail = node;
                if (next != null) {
                    dump.add(new Element(next));
                }
            }

            return head.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}