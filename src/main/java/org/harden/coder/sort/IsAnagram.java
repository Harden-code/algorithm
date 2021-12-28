package org.harden.coder.sort;

import java.util.Arrays;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 15:28
 * 文件说明： 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 长度相同，且级别也相同
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * </p>
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] ints = toInt(s);
        int[] ints1 = toInt(t);
        for(int i=0;i<ints.length;i++){
            if(ints[i]!=ints1[i]){
                return false;
            }
        }
        return true;
    }

    public int[] toInt(String s){
        int[] ints=new int[s.length()];
        for(int i=0;i<ints.length;i++){
            ints[i]=Character.getNumericValue(s.charAt(i));
        }
        Arrays.sort(ints);
        return ints;
    }
}
