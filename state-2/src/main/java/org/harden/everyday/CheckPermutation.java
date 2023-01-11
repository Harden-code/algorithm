package org.harden.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/27 10:40
 * 文件说明：面试题 01.02. 判定是否互为字符重排 </p>
 */
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        //长度不同直接pass
        if(s1.length()!=s2.length())return false;
        Map<Character,Integer> map=new HashMap<>();
        //记录每个char 的个数
        //如果s1 s2 的char个数相同就符合
        for (int i = 0; i < s1.length(); i++) {
            char c=s1.charAt(i);
            /**
             * getOrDefault key没有返回默认值1
             *
             * if(map.containsKey(c)){
             *      int count=map.get(c)+1;
             *      map.put(c,count);
             * }else{
             *      map.put(c,1);
             * }
             */
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // 减去个数
        for (int i = 0; i < s2.length(); i++) {
            char c=s1.charAt(i);
            map.put(c,map.getOrDefault(c,0)-1);
        }
        //遍历map 查看所有value是否等于0
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()!=0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1="abc";
        String s2="bca";
        CheckPermutation checkPermutation = new CheckPermutation();
        checkPermutation.checkPermutation(s1,s2);
    }
}
