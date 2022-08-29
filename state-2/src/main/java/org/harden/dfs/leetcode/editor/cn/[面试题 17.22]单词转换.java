//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 哈希表 字符串 回溯 👍 59 👎 0

package org.harden.dfs.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author junsenfu
 * @date 2022-07-18 22:38:46
 */
class WordTransformerLcci {
    public static void main(String[] args) {
        Solution solution = new WordTransformerLcci().new Solution();
//        String begin = "hit";
//        String end = "cog";
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String begin = "hot";
//        String end = "dog";
//        String[] words = {"hot", "dog"};
//        String begin = "lost";
//        String end = "miss";
//        String[] words = {"most","mist","miss","lost","fist","fish"};

        String begin = "leet";
        String end = "code";
        String[] words = {"lest", "leet", "lose", "code", "lode", "robe", "lost"};
        List<String> collect = Arrays.stream(words).collect(Collectors.toList());
        System.out.println(solution.findLadders(begin, end, collect).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Set<Character> path = new HashSet<>();

        private boolean flag = false;

        private Set<String> visited = new HashSet<>();
        private List<String> result = new ArrayList<>();

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return result;
            }
            for (int i = 0; i < wordList.size(); i++) {
                for (int j = 0; j < wordList.get(i).length(); j++) {
                    path.add(wordList.get(i).charAt(j));
                }
            }
            dfs(beginWord, endWord, wordList,new ArrayList<>());
//            System.out.println(result.toString());
            return result;
        }

        private void dfs(String beginWord, String endWord, List<String> wordList, List<String> path) {
//            if (index >= beginWord.length()) return;
            visited.add(beginWord);
            path.add(beginWord);
            if (beginWord.equals(endWord)) {
                result.addAll(path);
                flag = true;
                return;
            }
            //图上回溯
            for (int i = 0; i < wordList.size(); i++) {
                String next_word = wordList.get(i);
                //判断下个字符串和上一个字符串是否相差1 差一继续
                if (!isDiff(beginWord, next_word) || visited.contains(next_word)) {
                    continue;
                }
                dfs(next_word, endWord, wordList, path);
                path.remove(path.size() - 1);
            }
        }

        private boolean isDiff(String source, String target) {
            int count = 0;
            for (int i = 0; i < source.length(); i++) {
                char c1 = source.charAt(i);
                char c2 = target.charAt(i);
                if (c1 != c2) {
                    count++;
                }
            }
            return count == 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}