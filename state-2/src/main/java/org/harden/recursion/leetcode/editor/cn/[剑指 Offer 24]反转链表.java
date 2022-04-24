//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 429 👎 0

package org.harden.recursion.leetcode.editor.cn;

import org.harden.link.leetcode.editor.cn.ListNode;

/**
 * @author  junsenfu
 * @date 2022-04-23 22:08:24
 */
class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //3-2-1
        if(head==null||head.next==null){
            return head;
        }
        //返回头节点（尾巴节点）
        ListNode reverse = reverseList(head.next);
        //head.next=2
        //head.next.next 1 =>指向2
        //头节点的下个节点 执行头节点
        head.next.next=head;
        //头节点删除后面的新头节点
        //此时2->1 1->2成环 删除环
        head.next=null;
        return reverse;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}