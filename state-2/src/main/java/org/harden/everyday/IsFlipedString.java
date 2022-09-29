package org.harden.everyday;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/29 14:33
 * 文件说明：面试题 01.09. 字符串轮转 </p>
 */
public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
//        int i=0;
        int len = s1.length() - 1;
        //
        int p1 = 0, p2 = 0;
        //现让s2 于 s1的先匹配
        while (p1 <= len && s1.charAt(p1) != s2.charAt(p2)) {
            p1++;
        }
        boolean flag = false;
        while (p1 <= len && p2 <= len) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
                flag = true;
            } else {
                //处理出现重复的 复原操作
                p1++;
                if (flag) {
                    p2--;
                    flag = false;
                }
            }
        }
        p1 = 0;
        while (p2 <= len) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "wataaaerbottle", s2 = "aerbottlewataa";
        IsFlipedString is = new IsFlipedString();
        is.isFlipedString(s1, s2);
    }
}
