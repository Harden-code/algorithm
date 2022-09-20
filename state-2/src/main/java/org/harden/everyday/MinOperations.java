package org.harden.everyday;

import java.util.Stack;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/9 9:56
 * 1598. 文件夹操作日志搜集器
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/crawler-log-folder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 </p>
 */
public class MinOperations {
    public int minOperations(String[] logs) {
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            String val=logs[i];
            if("./".equals(val)){
                //保持原地不做处理
            }else if("../".equals(val)){
                //弹出
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(val);
            }
        }
        return stack.size();
    }
}
