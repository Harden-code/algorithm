package org.harden.everyday;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedDigits {

    public int rotatedDigits(int n) {
        //代表是否能进行旋转
        //0 可以旋转但不能改变一个数
        //1 可以旋转可以改变一个数
        //-1 不能旋转
        int[] ok = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        // 2, 5, 6, 9  =7
        // 0 1 8 =4
        // 3 4 7  =0
        int result = 0;
        //暴力计算所有相加
        //只有全部都能旋转才能计算
        for (int i = 1; i <= n; i++) {
            String num = Integer.toString(i);
            //f1 代表 可以旋转改变一个数
            //f2 代表 数不能旋转
            boolean f1 = false, f2 = true;
            for (char c : num.toCharArray()) {
                int val = c - '0';
                if (ok[val] == 1) {
                    f1 = true;
                }
                //代表不能旋转
                if (ok[val] == -1) {
                    f2 = false;
                }
            }
            if (f1 && f2) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        rotatedDigits.rotatedDigits(10);
    }
}
