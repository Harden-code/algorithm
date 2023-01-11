package org.harden.everyday;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/23 9:12
 * 文件说明： 707. 设计链表</p>
 */
public class MyLinkedList {
    private int size;

    private final Node head;

    private Node tail;

    public MyLinkedList() {
        this.head = new Node();
        this.tail = this.head;
        //个数
        this.size = 0;
    }

    public int get(int index) {
        if (this.size < index) return -1;
        int val = -1;
        //head是卫兵
        Node temp = head.next;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.val;
            }
            count++;
            temp = temp.next;
        }
        return val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        //处理tail
        if (this.head.next == null) {
            this.tail = node;
        }
        node.next = this.head.next;
        this.head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        this.tail.next = node;
        this.tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size) return;
        //注意 特殊节点 头尾
        //头节点添加
        if (index == 0) {
            addAtHead(val);
            return;
        }
        //尾节点添加
        if (this.size == index) {
            addAtTail(val);
            return;
        }
        Node temp = this.head.next;
        int count = 0;
        while (temp != null) {
            //找到删除下标前个节点
            if (count == index - 1) {
                break;
            }
            temp = temp.next;
            count++;
        }
        //中间节点
        if (temp != null) {
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        //头尾
        if (index > this.size-1) return;
        //头删
        if (index == 0) {
            this.head.next = this.head.next.next;
            this.size--;
            return;
        }
        //尾删
        if (this.size - 1 == index) {
            Node temp = this.head.next;
            while (temp.next != null) {
                if (temp.next == this.tail) {
                    temp.next = null;
                    this.tail = temp;
                    break;
                }
                temp = temp.next;
            }
            this.size--;
            return;
        }
        Node temp = this.head.next;
        int count = 0;
        while (temp != null) {
            //找到删除下标前个节点
            if (count == index - 1) {
                break;
            }
            temp = temp.next;
            count++;
        }

        if (temp != null) {
            temp.next = temp.next.next;
        }
//        //temp null 尾节点
//        if (prev != null && temp == null) {
//            prev.next = prev.next.next;
//            this.tail = prev;
//        }
        size--;

    }


    class Node {
        int val;

        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

//    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList();
////        myLinkedList.addAtHead(1);
////        myLinkedList.addAtTail(3);
////        myLinkedList.addAtIndex(1, 2);
////        System.out.println(myLinkedList.get(1));
//        myLinkedList.deleteAtIndex(0);  //现在链表是1-> 3
//        System.out.println(myLinkedList.get(0));
//                ["MyLinkedList"
//                ,"addAtHead" 7
//                ,"addAtHead" 2
//                ,"addAtHead" 1
//                ,"addAtIndex"  3 0
//                ,"deleteAtIndex" 2
//                ,"addAtHead" 6
//                ,"addAtTail"4
//                ,"get"4
//                ,"addAtHead"4
//                ,"addAtIndex"5 0
//                ,"addAtHead"] 6
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        System.out.println(myLinkedList.get(4));
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

//        myLinkedList.addAtIndex(0, 7);
//        myLinkedList.addAtIndex(0, 8);
//        myLinkedList.addAtIndex(0, 9);
//        myLinkedList.deleteAtIndex(1);
//        System.out.println(myLinkedList.get(0));



//                ,"addAtHead" 2
//                ,"deleteAtIndex" 1
//                ,"addAtHead", 2
//                "addAtHead", 7

//                "addAtHead", 3
//                "addAtHead", 2
//                "addAtHead", 5
//                "addAtTail", 5
//                "get",5
//                "deleteAtIndex"6
//                ,"deleteAtIndex" 4

//        myLinkedList.addAtHead(2);
//        myLinkedList.deleteAtIndex(1);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(7);
//
//        myLinkedList.addAtHead(3);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(5);
//        myLinkedList.addAtTail(5);
//        System.out.println(myLinkedList.get(5));
//        myLinkedList.deleteAtIndex(6);
//        myLinkedList.deleteAtIndex(4);
//
//    }
}
