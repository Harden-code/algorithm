package org.harden.coder.link;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/12 14:06
 * 文件说明：
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class HasCycle {
    /**
     * 使用快慢指针，因为快指针是慢指针的两倍，
     * 如果出现环，无论如何它们都会相遇。
     */
    public static boolean hasCycle(ListNode head) {
        //[1,2] 如果只有一位 下面取快指针就会 空指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null||fast.next == null ) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
//        while (fast != null && fast.next!=null ) {
//            //[1,1,1,1]
//            if(fast.val==slow.val){
//                return true;
//            }
//            //指针移动
//            slow = slow.next;
//            fast = fast.next.next;
//        }
    }




    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2,node4);
        hasCycle(node3);
    }
}
