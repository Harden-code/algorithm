//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1976 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import java.util.*;

/**
 * @author junsenfu
 * @date 2022-06-29 22:28:57
 */
class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> result = new ArrayList<>();


        Map<Character,String> hash=new HashMap<>();
        public List<String> letterCombinations(String digits) {
            if(digits.length()==0){
                return result;
            }
            hash.put('2',"abc");
            hash.put('3',"def");
            hash.put('4',"ghi");
            hash.put('5',"jkl");
            hash.put('6',"mno");
            hash.put('7',"pqrs");
            hash.put('8',"tuv");
            hash.put('9',"wxyz");
            backTrace(digits,new ArrayList<>(),0);
            return result;
        }

        private void backTrace(String digits,List<Character> path,int k) {
            if(digits.length()==k){
                char[] chars=new char[path.size()] ;
                for (int i = 0; i < chars.length; i++) {
                    chars[i]=path.get(i);
                }
                String s=new String(chars);
                result.add(s);
                return;
            }
            char key = digits.charAt(k);
            //每个号码就是一个决策
            String s = hash.get(key);
            for (int i = 0; i < s.length(); i++) {
                char c=s.charAt(i);
                path.add(c);
                backTrace(digits,path,k+1);
                path.remove(path.size()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}