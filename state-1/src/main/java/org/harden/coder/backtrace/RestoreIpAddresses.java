package org.harden.coder.backtrace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/22 22:50
 * 文件说明：93. 复原 IP 地址 </p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class RestoreIpAddresses {
    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return result;
        }
        backTrace(new ArrayList<>(),s,0);
        return result;
    }

    public void backTrace(List<String> path, String s, int k) {
        if(path.size()>4){
            return;
        }
        if (k ==  s.length()) {
            if(path.size()==4){
                String ip = path.stream()
                        .collect(Collectors.joining("."));
                result.add(ip);
            }
            return;
        }
        //0 1,递归是遍历s的长度，为了切分  k切分的长度
        for (int i = k; i < s.length(); i++) {
            String substring = s.substring(k, i + 1);
            if (isIp(substring)) {
                path.add(substring);
                backTrace(path,s,i+1);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isIp(String s) {
        if (s.length() > 3) {
            return false;
        }
        //010
        if(s.charAt(0)=='0'&&s.length()>1){
            return false;
        }
        //判断是否为数字
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            }
            return false;
        }
        int num = 0;
        //str to int
        for (int i = 0; i < s.length(); i++) {
            num = (s.charAt(i) - '0') + num * 10 ;
        }
        if (num > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        restoreIpAddresses.restoreIpAddresses("101023").forEach(System.out::println);

    }
}
