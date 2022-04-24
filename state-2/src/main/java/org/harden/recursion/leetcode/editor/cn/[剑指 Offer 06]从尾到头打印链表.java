//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 279 👎 0

package org.harden.recursion.leetcode.editor.cn;

import org.harden.link.leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  junsenfu
 * @date 2022-04-23 21:34:17
 */
class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
//    head = [1,3,2]
//    [2,3,1]
    public int[] reversePrint(ListNode head) {
        //两种方法 一种是用栈
        //递归
        List<Integer> list=new ArrayList<>();
        print(head,list);
        int[] resul=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resul[i]=list.get(i);
        }
        return resul;
    }

    private void print(ListNode head,List<Integer> list){
        if(head==null){
            return;
        }
        print(head.next,list);
        list.add(head.val);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}