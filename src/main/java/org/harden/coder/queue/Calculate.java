package org.harden.coder.queue;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/19 15:26
 * 文件说明：
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class Calculate {
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {

            //去除空格
            if (chars[i] == ' ') {
                i++;
                continue;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                //数字
                int num = 0;
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                nums.push(num);
            } else {
                //优先级低 * /  直接加入
                if (ops.isEmpty() || prior(chars[i], ops.peek())) {
                    ops.push(chars[i]);
                }else{
                    //peek * /  index + - 消除  栈顶元素必须为* /
                    while (!ops.isEmpty()&&!prior(chars[i],ops.peek())){
                        fetch(ops,nums);
                    }
                }
                i++;
            }
        }
        while (!ops.isEmpty()){
            fetch(ops,nums);
        }

        return nums.pop();
    }

    public void fetch(Stack<Character> ops,Stack<Integer> nums){
        Integer num2=nums.pop();
        Integer num1=nums.pop();
        Character character=ops.pop();
        int i = calculateInt(character, num1, num2);
        nums.push(i);
    }

    public boolean prior(char a, char b) {
        return (a == '*' || a == '/') && (b == '+' || b == '-');
    }

    public int calculateInt(Character c, int i,int j) {
        switch (c) {
            case '+':
                return i + j;
            case '-':
                return i - j;

            case '*':
                return i * j;

            case '/':
                return i / j;
        }
        return 0;

    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("3+2*2"));
    }
}
