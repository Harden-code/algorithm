//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 229 👎 0

package org.harden.link.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-03-30 22:45:27
 */
class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode tail = head;
            ListNode h1 = l1;
            ListNode h2 = l2;
            //先排序比较
            while (h1 != null && h2 != null) {
                int p1 = h1.val;
                int p2 = h2.val;
                if (p1 < p2) {
                    tail.next = h1;
                    tail = h1;
                    h1 = h1.next;
                } else {
                    tail.next = h2;
                    tail = h2;
                    h2 = h2.next;
                }
            }
            //处理剩余的节点
            if (h1 != null) {
                tail.next = h1;
            }
            if (h2 != null) {
                tail.next = h2;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}