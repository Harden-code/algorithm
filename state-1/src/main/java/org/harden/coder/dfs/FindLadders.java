package org.harden.coder.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/16 21:35
 * 文件说明：面试题 17.22. 单词转换 </p>
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。
 * 每一步得到的新词都必须能在字典中找到。
 * <p>
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>
 * <p>
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-transformer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLadders {
    private List<String> result = new ArrayList<>();

    private Set<String> visit = new HashSet<>();

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return result;
        }
        dfs(beginWord, endWord, wordList);
        return result;
    }

    public void dfs(String beginWord, String endWord, List<String> wordList) {
        visit.add(beginWord);
        result.add(beginWord);
        if (beginWord.equals(endWord)) {
            return;
        }
        for (int j = 0; j < endWord.length(); j++) {
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);
                String newStr = create(beginWord, word, j);
                if (!wordList.contains(newStr) || visit.contains(newStr)) {
                    continue;
                }
                //拿出来
                dfs(newStr, endWord, wordList);
            }
        }

    }

    public String create(String target, String source, int p) {
        char[] targetC = target.toCharArray();
        char[] sourceC = source.toCharArray();
        targetC[p] = sourceC[p];
        return new String(targetC);
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        findLadders.findLadders("hit", "cog", wordList).forEach(System.out::println);
    }
}
