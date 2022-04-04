//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
// Related Topics 链表 👍 560 👎 0

package org.harden.link.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-04-04 18:22:41
 */
class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);
        solution.oddEvenList(node4);
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
        public ListNode oddEvenList(ListNode head) {
            //使用一个独立的链表记录奇数,最后在相加
            ListNode dummyA = new ListNode();
            ListNode tailA = dummyA;
            //偶数
            ListNode dummyB = new ListNode();
            ListNode tailB = dummyB;
            ListNode h = head;
            int i = 0;
            while (h != null) {
                ListNode temp = h.next;
                //奇数 特殊情况：下一位为空
                if (i % 2 != 0) {
                    tailB.next = h;
                    tailB = h;
                    h.next = null;

                }
                if (i % 2 == 0) {
                    tailA.next = h;
                    tailA = h;
                    h.next = null;
                }
                i++;
                h = temp;
            }
            //头节点为奇数

            tailA.next = dummyB.next;
            return dummyA.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}