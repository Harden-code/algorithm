package org.harden.coder;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/4 21:45
 * 文件说明： </p>
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }


}
