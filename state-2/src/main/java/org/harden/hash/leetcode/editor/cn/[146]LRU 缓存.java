//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 2178 👎 0

package org.harden.hash.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-05-19 22:01:09
 */
class Lru {
    public static void main(String[] args) {
//        [2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        LRUCache solution = new Lru().new LRUCache(2);
        solution.get(2);
        solution.put(2,6);
        solution.put(1,5);
        solution.put(1,2);
        solution.get(1);
        System.out.println(solution.get(2));

        System.out.println(solution.get(1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private final int capacity;

        private int count=0;

        private final Node[] linkList;

        private final Node head;

        private final Node tail;

        private class Node{
            private int key;
            private int value;

            private Node next;

            private Node pre;

            public Node(int value) {
                this.value = value;
            }
            public Node(int key,int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.capacity=capacity;
            linkList=new Node[10001];
            this.head=new Node(-1);
            this.tail=new Node(-2);
            this.head.next=tail;
            this.tail.pre=head;
        }

        public int get(int key) {
            if(linkList[key]!=null){
                removeNode(linkList[key]);
                inertHead(linkList[key]);
                return linkList[key].value;
            }
            return -1;
        }

        public void put(int key, int value) {
            //为空且大于容量
            if(linkList[key]==null&&count>=capacity){
                remove();
            }
            if(linkList[key]!=null){
                Node node=linkList[key];
                node.value=value;
                removeNode(linkList[key]);
                inertHead(linkList[key]);
            }else {
                Node node = new Node(key,value);
                linkList[key]=node;
                inertHead(node);
                count++;
            }

        }

        private void remove(){
           int value= tail.pre.key;
           linkList[value]=null;
           removeNode(tail.pre);
           count--;
        }

        private void removeNode(Node node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
            node.pre=null;
            node.next=null;
        }

        private void inertHead(Node node){
            Node next=this.head.next;
            node.next=next;
            next.pre=node;
            this.head.next=node;
            node.pre=head;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}