//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3152 👎 0

package org.harden.stack.leetcode.editor.cn;

import java.util.*;

/**
 * @author junsenfu
 * @date 2022-04-06 22:13:23
 */
class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("([}}])");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //'('，')'，'{'，'}'，'['，']'

        public boolean isValid(String s) {
            List<Character> charsA= new ArrayList<>();
            charsA.add('(');
            charsA.add('{');
            charsA.add('[');
            List<Character> charsB= new ArrayList<>();
            charsB.add(')');
            charsB.add('}');
            charsB.add(']');
            //栈里装不能消除的括号
            Stack<Character> stack=new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty()){
                    Character peek =stack.peek();
                    if(charsA.contains(peek)&&charsB.contains(s.charAt(i))&&peek.equals(converte(s.charAt(i)))){
                        stack.pop();
                        continue;
                    }
                }
                stack.push(s.charAt(i));
            }
            return stack.isEmpty();
        }

        public char converte(char c){
            if(c==')'){
                return '(';
            }else if(c==']'){
                return '[';
            }else if(c=='}'){
                return '{';
            }else {
                return c;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}