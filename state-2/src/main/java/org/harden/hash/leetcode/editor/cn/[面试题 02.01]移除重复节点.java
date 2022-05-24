//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 哈希表 链表 双指针 👍 158 👎 0

package org.harden.hash.leetcode.editor.cn;

import org.harden.link.leetcode.editor.cn.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author  junsenfu
 * @date 2022-05-18 21:48:33
 */
class RemoveDuplicateNodeLcci{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
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
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> values=new HashSet<>();
        ListNode h=head;
        ListNode new_head=new ListNode();
        ListNode tail=new_head;
        while (h!=null){
            ListNode next=h.next;
            if(values.contains(h.val)){
                h=h.next;
                continue;
            }
            values.add(h.val);
            tail.next=h;
            tail=h;
            //去除h的下一个节点
            h.next=null;
            h=next;
        }
        return new_head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}