//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1326 👎 0

package org.harden.link.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-04-01 21:26:50
 */
class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
//        ListNode node3 = new ListNode(0, node2);
//        ListNode node4=new ListNode(2,node3);
//        ListNode node5=new ListNode(1,node4);
        System.out.println(solution.isPalindrome(node2));
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
        public boolean isPalindrome(ListNode head) {

            //找到链表中点进行切分 反转后半部分
            ListNode mid = mid(head);
            ListNode temp=mid;
            ListNode newH = reverse(temp);
            while (newH != null && head != null) {
                if (newH.val != head.val) {
                    return false;
                }
                newH = newH.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode h = head;
            ListNode pre=null;
            while (h != null) {
                ListNode temp = h.next;
                h.next = pre;
                pre = h;
                h = temp;
            }
            return pre;
        }

        public ListNode mid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //偶数
            if (fast.next != null) {
                return slow.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}