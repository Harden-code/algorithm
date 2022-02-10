package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/22 14:33
 * 文件说明：131. 分割回文串 </p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class Partition {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrace(new ArrayList<>(), s, 0);
        return result;
    }

    public void backTrace(List<String> path, String s, int k) {
        if (k == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //截取成不同段
        for (int i = k; i < s.length(); i++) {
            String substring = s.substring(k, i + 1);
            if (isBack(substring, 0, substring.length()-1)) {
                path.add(substring);
                backTrace(path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }


    public boolean isBack(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        partition.partition("aab").forEach(System.out::println);
    }
}