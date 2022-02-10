package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/18 22:45
 * 文件说明： 17. 电话号码的字母组合</p>
 */
public class LetterCombinations {
    private List<String> result=new ArrayList<>();

    private String[] nums=new String[]{"","","abc","def"
            ,"ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return result;
        }
        String[] str=new String[digits.length()];
        for(int i=0;i<digits.length();i++){
            str[i]=nums[digits.charAt(i)-'0'];
        }
        backTrace(str,0,new char[digits.length()]);
        return result;
    }

    public void backTrace(String[] str,int path,char[] chars){
        if(path==str.length){
            result.add(new String(chars));
            return;
        }
        //位数跟digits 长度相同,所有第一个元素模式是digits[0] 否则就不符合
        /**
         *     a      b      c   一层
         *   d e f  d e f  d e f  二层
         */
        char[] map=str[path].toCharArray();
        for(int i=0;i<map.length;i++){
            chars[path]=map[i];
            backTrace(str, path+1, chars);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        strings.forEach(System.out::println);
    }
}
