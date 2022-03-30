//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 👍 757 👎 0

package org.harden.link.leetcode.editor.cn;

import java.util.jar.JarEntry;

/**
 * @author junsenfu
 * @date 2022-03-30 22:08:02
 */
class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
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
        //输入：head = [1,1,2,3,3]
        //输出：[1,2,3]
        public ListNode deleteDuplicates(ListNode head) {
            ListNode h = head;
            while (h != null) {
                //用当前和下一个判断，如果重复删除并且继续下标不移动
                if (h.next != null && h.next.val == h.val) {
                    h.next=h.next.next;
                    continue;
                }
                h = h.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}