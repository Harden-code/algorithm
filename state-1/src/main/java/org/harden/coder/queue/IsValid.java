package org.harden.coder.queue;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/14 21:40
 * 文件说明：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> queue=new Stack<>();
        for(int i=0;i<chars.length;i++){
            char b=chars[i];
            if(queue.size()==0){
                //头插入
                queue.push(b);
                continue;
            }
            Character peek = queue.peek();
            if(peek=='('){
                if(b==')'){
                    queue.pop();
                }else if(b=='('||b=='{' ||b=='['){
                    queue.push(b);
                }else {
                    return false;
                }
            }
            if(peek=='{'){
                if(b=='}'){
                    queue.pop();
                }else if(b=='('||b=='{' ||b=='['){
                    queue.push(b);
                }else {
                    return false;
                }
            }
            if(peek=='['){
                if(b==']'){
                    queue.pop();
                }else if(b=='('||b=='{' ||b=='['){
                    queue.push(b);
                }else {
                    return false;
                }
            }

        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("(])"));


    }
}
