package org.harden.coder.hash;

import org.harden.coder.link.ListNode;
import org.w3c.dom.ls.LSException;

import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/3 0:23
 * 文件说明：
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。
 * 如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class MyHashMap {
    private class Node {
        private int key;

        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int size = 3535;

    private LinkedList<Node>[] linkedLists;

    public MyHashMap() {
        linkedLists = new LinkedList[size];
        for(int i=0;i<size;i++){
            linkedLists[i]=new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        // 如果没有直接插入，否则先删除后插入
        int hash = hash(key);
        LinkedList<Node> linkedList = linkedLists[hash];
        //删除当前节点
        linkedList.removeIf(node -> node.key == key);
        linkedList.add(new Node(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        LinkedList<Node> linkedList = linkedLists[hash];
        for (Node node : linkedList) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Node> linkedList = linkedLists[hash];
        linkedList.removeIf(e -> e.key == key);
    }

    private int hash(int key) {
        return key % size;
    }
}
