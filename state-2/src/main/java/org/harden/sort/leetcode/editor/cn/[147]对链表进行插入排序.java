//给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。 
//
// 插入排序 算法的步骤: 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表
//中。 
//
// 对链表进行插入排序。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [4,2,1,3]
//输出: [1,2,3,4] 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [-1,5,3,4,0]
//输出: [-1,0,3,4,5] 
//
// 
//
// 提示： 
//
// 
//
// 
// 列表中的节点数在 [1, 5000]范围内 
// -5000 <= Node.val <= 5000 
// 
// Related Topics 链表 排序 👍 509 👎 0

package org.harden.sort.leetcode.editor.cn;

import org.harden.link.leetcode.editor.cn.ListNode;

import java.util.List;

/**
 * @author junsenfu
 * @date 2022-04-27 22:04:23
 */
class InsertionSortList {
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();
        ListNode node1 = new ListNode(3);

        ListNode node2 = new ListNode(1,node1);
        ListNode node3 = new ListNode(2, node2);

        solution.insertionSortList(node3);
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
        //输入: head = [-1,5,3,4,0]
        //输出: [-1,0,3,4,5]
        public ListNode insertionSortList(ListNode head) {
            ListNode h = head;
            ListNode new_h = new ListNode(Integer.MIN_VALUE);
            while (h != null) {
                ListNode temp = h.next;
                ListNode linked = new_h;
                while (linked != null) {
                    //下个节点为空或者下个节点大于 h直接插入
                    if (linked.next==null||linked.next.val > h.val) {
                        //进行插入
                        ListNode tail = linked.next;
                        linked.next = h;
                        h.next = tail;
                        break;
                    }
                    linked=linked.next;
                }
                h = temp;
            }
            return new_h.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}