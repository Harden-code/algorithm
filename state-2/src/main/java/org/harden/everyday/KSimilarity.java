package org.harden.everyday;

import sun.plugin2.gluegen.runtime.CPU;

import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/21 9:31
 * 文件说明：854. 相似度为 K 的字符串 </p>
 */

public class KSimilarity {

    private int count = Integer.MAX_VALUE;

    /**
     * dfs
     */
    public int kSimilarity(String s1, String s2) {
        char[] path = s1.toCharArray();
        backTrace(s2, path, 0, 0);
        return count;
    }

    private void backTrace(String target, char[] path, int i, int k) {
        if (count < k) return;

        if (i == target.length()) {
            String str = new String(path);
            System.out.println(new String(path));
            if (str.equals(target)) {
                count = Math.min(k, count);
            }
            return;
        }
        //相同就继续想下走
        if (path[i] == target.charAt(i)) {
            backTrace(target, path, i + 1, k);
        }
        //每个阶段寻找不同的进行交换
        for (int p = i + 1; p < path.length; p++) {
            if (path[p] == target.charAt(i) && path[p] != target.charAt(p)) {
                swap(path, i, p);
//                    System.out.println(new String(path));
                backTrace(target, path, i + 1, k + 1);
                swap(path, i, p);
            }
        }

    }

    /**
     * 图上bfs
     */
    public int kSimilarity_bfs(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(s1);
        visited.add(s1);
        int result = 1;//1层进去
        while (!queue.isEmpty()) {
            int count = queue.size();
            //处理每层逻辑
            for (int i = 0; i < count; i++) {
                String poll = queue.poll();
                List<String> all = getAll(poll, s2);
                for (String s : all) {
                    if (s.equals(s2)) {
                        return result;
                    }
                    if (!visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
            result++;

        }
        return result;
    }


    private List<String> getAll(String s1, String s2) {
        List<String> result = new ArrayList<>();
        int index = 0;

        for (; index < s1.length(); index++) {
            if (s1.charAt(index) != s2.charAt(index)) {
                break;
            }
        }
        //在于状态的转换 每次只能交换一个字符
        //当s1[i]和s2[i]下标不同进行转换
        //当要转换的s1下标与s2转换的下标相同 也就是s1[j]==s2[i]且
        // s1的下标j不能与s2的下标j相同(相同意味着相同下标相等,交换后增加了次数)
        for (int j = index + 1; j < s1.length(); j++) {
            char[] chars = s1.toCharArray();
            if (chars[j] == s2.charAt(index) && chars[j] != s2.charAt(j)) {
                swap(chars, index, j);
                String str = new String(chars);
                result.add(str);
            }

        }

        return result;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    public static void main(String[] args) {
//           String s1 = "abc", s2 = "bca";
//        String s1 = "abcdfe", s2 = "febcda";
//        String s1 = "abccaacceecdeea";
//        String s2 = "bcaacceeccdeaae";
        String s1 = "abcdeabcdeabcdeabcde";
        String s2 = "aaaabbbbccccddddeeee";
        KSimilarity kSimilarity = new KSimilarity();
        System.out.println(kSimilarity.kSimilarity(s1, s2));
    }

}
