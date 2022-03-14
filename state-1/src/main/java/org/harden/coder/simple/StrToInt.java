package org.harden.coder.simple;


/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/1 19:11
 * 文件说明：
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class StrToInt {
    /**
     * 遍历 过滤空格 并查看第一个字符是否为数字
     * "   34" "-34 " "w1" “-” “-0”
     * 溢出情况
     */

    public static int strToInt(String str) {
        char[] chars = str.toCharArray();
        int n = 0;

        int num = 0;
        //转换数字
        int sign = 1;
        //去空格字母
        while (n < chars.length) {
            //判断第一是否为字母 //.1 46
            if (chars[n] > '9' || chars[n]=='.') {
                return num;
            }
            //处理符号 '-'符号 "+-2"
            if (chars[n] == '-') {
                sign = -1;
                //移动位置
                n++;
                break;
            }
            if(chars[n]=='+'){
                n++;
                break;
            }
            //是字母
            if ((chars[n] >= '0' && chars[n] <= '9')) {
                break;
            }
            n++;
        }
        //全是空格
        if (n == chars.length) {
            return 0;
        }

        int intAbsHigh = 214748364;

        while (n < chars.length&& chars[n] <= '9'&&chars[n] >= '0') {

            int d = chars[n] - '0';
            //-2147483648 int 2147483647
            //处理溢出
            if (num > intAbsHigh) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            if (num == intAbsHigh) {
                if ((sign == 1) && (d > 7)) {
                    return Integer.MAX_VALUE;
                }
                if ((sign == -1) && (d > 8)){
                    return Integer.MIN_VALUE;
                }
            }
            //转换 "100"->100  0*10  1*10  10*10
            num=num*10+d;
            n++;

        }
        return num * sign;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("  w 4"));
        System.out.println(strToInt("   42"));
        System.out.println(strToInt("   -4w2"));
        System.out.println(strToInt("   .1"));
        System.out.println(strToInt("   -w"));
        System.out.println(strToInt("-"));

    }
}
