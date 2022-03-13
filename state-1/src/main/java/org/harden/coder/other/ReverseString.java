package org.harden.coder.other;

/**
 * 344. 反转字符串
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length;
        while (i<j){
            char first=s[i];
            s[i]=s[j];
            s[j]=first;
            j--;
            i++;
        }
    }
}
