package org.harden.coder.other;

import java.util.Arrays;
import java.util.List;

/**
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个单词，
 * 找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"],
 * word1 = "a", word2 = "student"
 * 输出：1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindClosest {
    public int findClosest(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                for (int j = i; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        result = Math.min(result, j - i);
                    }
                }
            }
            if (word.equals(word2)) {
                for (int j = i; j < words.length; j++) {
                    if (words[j].equals(word1)) {
                        result = Math.min(result, j - i);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String a = "a";
        String b = "student";
        FindClosest findClosest = new FindClosest();
        System.out.println(findClosest.findClosest(words, a, b));
    }
}
