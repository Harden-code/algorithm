//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1921 👎 0

package org.harden.link.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-03-31 00:22:03
 */
class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node=new ListNode(1);
        solution.removeNthFromEnd(node,1);
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h=head;
        int count =0;
        while (h!=null){
            count++;
            h=h.next;
        }

        int i=0;
        h=head;
        count=count-n;
        //删除头节点
        if(count==0){
            return head.next;
        }
        while (h!=null){
            i++;
            if(i==count){
                h.next=h.next.next;
                break;
            }

            h=h.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}