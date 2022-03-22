//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
//
//
// 注意：此题对比原题有改动 
// Related Topics 双指针 字符串 👍 183 👎 0

package org.harden.simple.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author junsenfu
 * @date 2022-03-20 14:46:11
 */
class FanZhuanDanCiShunXuLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanDanCiShunXuLcof().new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            //装入单词的集合
            List<String> list = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int q = i;

                //出现越界,少计算一次
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
                if (q != i) {
                    //会出现空格
                    list.add(s.substring(q, i));
                } else {
                    i++;
                }
            }
            i = 0;
            int j = list.size() - 1;
            while (i < j) {
                String first = list.get(i);
                String last = list.get(j);
                list.set(i, last);
                list.set(j, first);
                i++;
                j--;
            }
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < list.size(); k++) {
                if (k >= 1) {
                    builder.append(" ");
                }
                builder.append(list.get(k));
            }
            return builder.toString();
        }

        public String replace(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                char c = str.charAt(i);
                if (c != ' ') {
                    stringBuilder.append(c);
                }
                i++;
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}