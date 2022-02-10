package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/23 15:27
 * 文件说明： 22. 括号生成</p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 */
public class GenerateParenthesis {
    private List<String> result=new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        return result;
    }

    public void backTrace(List<String> path,String[] s,int left,int rigth,int k){
        if(k==s.length){
            result.add(path.toString());
            return;
        }

    }
}
