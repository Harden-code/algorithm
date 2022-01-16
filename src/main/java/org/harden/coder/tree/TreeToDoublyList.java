package org.harden.coder.tree;


/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/11 15:03
 * 文件说明：
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * </p>
 */
public class TreeToDoublyList {
    private Node head = new Node();

    private Node tail = head;

    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        dfs(root);
        Node n = head.right;
        while (n.right!=null){
            Node next = n.right;
            next.left=n;
            n=next;
        }
        head.right.left = tail;
        tail.right = head.right;
        return head.right;
    }

    public Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        Node l = dfs(node.left);
        tail.right=node;
        node.left=null;
        tail=node;

        Node r = dfs(node.right);
//        if (l != null&&r==null) {
//            l.right = node;
//            node.left = l;
//            //tail
//            tail.right = l;
//            tail = node;
//        } else if (r != null&&l==null) {
//            node.right = r;
//            r.left = node;
//            tail.right = node;
//            tail = r;
//        } else if (l != null && r != null) {
//            l.right = node;
//            node.left = l;
//            node.right = r;
//            r.left = node;
//            tail.right = r;
//            tail = r;
//        }
        return node;
    }

    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node1 = new Node(1);
        Node node2 = new Node(2,node1,node3);

        Node node5 = new Node(5);
        Node node4 = new Node(4,node2,node5);

        TreeToDoublyList treeToDoublyList = new TreeToDoublyList();

        treeToDoublyList.treeToDoublyList(node4);

    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
