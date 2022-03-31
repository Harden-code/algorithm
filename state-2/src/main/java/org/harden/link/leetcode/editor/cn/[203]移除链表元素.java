//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 851 👎 0

package org.harden.link.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-03-30 21:24:18
 */
class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        solution.removeElements(listNode4, 2);
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
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            ListNode h = new ListNode();
            h.next = head;
            //游标节点
            ListNode temp = h;
            while (temp != null) {
                if (temp.next != null && temp.next.val == val) {
                    //删除链表 直接把当前节点的下个节点指向 下下个节点
                    temp.next = temp.next.next;
                    //不加contine 游标会划下去导致漏掉
                    continue;
                }
                temp = temp.next;
            }
            return h.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}