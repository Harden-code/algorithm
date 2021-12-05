package org.harden.coder.simple;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/11/30 23:45
 * 文件说明： </p>
 *
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 */
public class IpAddr {
    public static String ipAddr(String address) {
        char[] chars = address.toCharArray();
        //计算长度
        int len=chars.length+2*3;
        char[] newAddr=new char[len];
        for(int i=0,j=0;i<chars.length;i++,j++){
            if(chars[i]=='.'){
                newAddr[j]='[';
                newAddr[++j]='.';
                newAddr[++j]=']';
            }else {
                newAddr[j]=chars[i];
            }
        }
        return new String(newAddr);
    }

    public static void main(String[] args) {
        String s = ipAddr("1.1.1.1");
        System.out.println(s);
    }
}
