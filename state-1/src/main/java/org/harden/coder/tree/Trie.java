package org.harden.coder.tree;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/16 22:33
 * 文件说明： 208. 实现 Trie (前缀树)</p>
 */
public class Trie {

    private final Node root;

    private class Node{
        private final char value;

        private boolean isEnd;

        private final Node[] child=new Node[26];

        public Node(char value) {
            this.value = value;
        }
    }


    public Trie() {
        root=new Node('/');
    }

    public void insert(String word) {
        Node parent=root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(parent.child[c-'a']==null){
                parent.child[c-'a']=new Node(c);
            }
            //下移动
            parent= parent.child[c-'a'];
        }
        parent.isEnd=true;
    }

    public boolean search(String word) {
        Node parent=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            //子节点没有直接返回
            if(parent.child[c-'a']==null){
                return false;
            }
            parent=parent.child[c-'a'];
        }
        return parent.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node parent=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(parent.child[c-'a']==null){
                return false;
            }
            parent=parent.child[c-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}
