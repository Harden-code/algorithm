package org.harden.coder.simple;

import java.util.Scanner;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/4 12:01
 * 文件说明：
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * </p>
 */
public class OneEditAway {
    public static boolean oneEditAway(String first, String second) {
        int n = first.length();
        int m = second.length();
        //绝对值大于0
        if (Math.abs(n - m) > 1) {
            return false;
        }
        // first的下标 n
        int i = 0;
        //second的下表 m
        int j = 0;
        //找到第一个不等于
        while (i < n && j < m && first.charAt(i) == second.charAt(i)) {
            i++;
            j++;
        }
        //替换
        if (n == m) {
            i++;
            j++;
        } else if (n > m) {
            i++;
        } else { //插入和添加
            j++;
        }
        //跳过后，再不相等就错
        while (i < n && j < m) {
            if (first.charAt(i) != second.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(oneEditAway("islander", "slander"));

        System.out.println(oneEditAway("pale", "xsle"));

        System.out.println(oneEditAway("pale", "xle"));
    }
}
