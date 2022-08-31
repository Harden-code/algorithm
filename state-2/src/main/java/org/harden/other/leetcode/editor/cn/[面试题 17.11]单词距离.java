//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 👍 93 👎 0

package org.harden.other.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-08-23 22:16:16
 */
class FindClosestLcci{
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String value=words[i];
            if(value.equals(word1)){
                //找word2
                int j=find_close(words,i,word2);
                if(j!=-1){
                    min=Math.min(j-i,min);
                }
            }
            if(value.equals(word2)){
                //找word1
                int j=find_close(words,i,word1);
                if(j!=-1){
                    min=Math.min(j-i,min);
                }
            }
        }

        return min;
    }

    private int find_close(String[] words,int i,String target){
        while (i<words.length){
            if(words[i].equals(target)){
                return i;
            }
            i++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}