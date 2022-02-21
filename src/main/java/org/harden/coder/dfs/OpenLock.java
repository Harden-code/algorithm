package org.harden.coder.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/19 21:07
 * 文件说明： 752. 打开转盘锁</p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字：
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：
 * 例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OpenLock {

    /**
     * 0000
     * 0001 0010 0100 1000 0009 0090 0900 9000
     * 1001 0101 0011 0012
     */
    private Set<String> visit = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        String source = "0000";
        if (target.equals(source)) {
            return 0;
        }
        for (int i = 0; i < deadends.length; i++) {
            if (deadends[i].equals(source)) {
                return -1;
            }
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(source);
        visit.add(source);
        int result = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            for (int i = 0; i < len; i++) {
                String poll = queue.poll();
                List<String> nodes = genNewNode(poll);
                for (String node : nodes) {
                    if (visit.contains(node) || isDead(deadends, node)) {
                        continue;
                    }
                    if (node.equals(target)) {
                        return result;
                    }

                    queue.offer(node);
                    visit.add(node);

                }
            }
        }

        return -1;
    }

    public List<String> getNums(String source) {
        int[] dic = {1, -1};
        List<String> nodes = new ArrayList<>();
        char[] chars = new char[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < dic.length; j++) {
                //i=0
                for (int p = 0; p < i; p++) {
                    chars[p] = source.charAt(p);
                }
                //i=1 先装倒序
                for (int p = i + 1; p < 4; p++) {
                    chars[p] = source.charAt(p);
                }
                int num = source.charAt(i) - '0';
                String newChar=(num+10+dic[j])%10+"";
                chars[i]=newChar.charAt(0);
                nodes.add(new String(chars));
            }
        }
        return nodes;
    }

    public boolean isDead(String[] deadends, String source) {
        for (int j = 0; j < deadends.length; j++) {
            if (source.equals(deadends[j])) {
                return true;
            }
        }
        return false;
    }


    private List<String> genNewNode(String node) {
        List<String> newnodes = new ArrayList<>();
        int[] change = {-1, 1};
        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 2; ++k) {
                char[] newNode = new char[4];
                for (int j = 0; j < i; ++j) {
                    newNode[j] = node.charAt(j);
                }
                for (int j = i + 1; j < 4; ++j) {
                    newNode[j] = node.charAt(j);
                }
                String newC = (((node.charAt(i) - '0') + change[k] + 10) % 10) + "";
                newNode[i] = newC.charAt(0);
                newnodes.add(new String(newNode));
            }
        }
        return newnodes;
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
//        String[] deal = {"0201", "0101", "0102", "1212", "2002"};
//        String source = "0202";
//        System.out.println(openLock.openLock(deal, source));
        openLock.getNums("0000").forEach(System.out::println);
    }
}
