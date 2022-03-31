//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 112 👎 0

package org.harden.simple.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-03-22 21:22:57
 */
class OneAwayLcci{
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        solution.oneEditAway("islander","slander");
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        //距离只能为1
        if(Math.abs(first.length()-second.length())>1){
            return false;
        }
        //first的下标
        int i=0;
        //second的下标
        int j=0;
        int n=0;
        while (i<first.length()&&j<second.length()){
            if (first.charAt(i) == second.charAt(j)) {
                //两字符相等
                i++;
                j++;
            }else {
                //多的加
                if(first.length()>second.length()){
                    //增加
                    i++;
                }else if(first.length()<second.length()) {
                    //增加
                    j++;
                }else {
                    //相等双删除
                    i++;
                    j++;
                }
                n++;
            }
        }

        return n<=1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}