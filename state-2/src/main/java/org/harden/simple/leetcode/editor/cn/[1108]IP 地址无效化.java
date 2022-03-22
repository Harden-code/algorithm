////给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。 
////
//// 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。 
////
//// 
////
//// 示例 1： 
////
//// 输入：address = "1.1.1.1"
////输出："1[.]1[.]1[.]1"
//// 
////
//// 示例 2： 
////
//// 输入：address = "255.100.50.0"
////输出："255[.]100[.]50[.]0"
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 给出的 address 是一个有效的 IPv4 地址 
//// 
//// Related Topics 字符串 👍 77 👎 0
//

package org.harden.simple.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-03-18 22:41:42
 */
 class DefangingAnIpAddress{
    public static void main(String[] args) {
        Solution solution = new DefangingAnIpAddress().new Solution();
        solution.defangIPaddr("1.1.1.1");
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String defangIPaddr(String address) {
        char[] chars=new char[address.length()+2*3];
        int i=0;
        int k=0;
        while (i<address.length()){
            if(address.charAt(i)=='.'){
                chars[k++]='[';
                chars[k++]='.';
                chars[k++]=']';

            }else {
                chars[k++]=address.charAt(i);
            }
            i++;//必须跟到加 不是下标要出问题
        }
        System.out.println(new String(chars));
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}