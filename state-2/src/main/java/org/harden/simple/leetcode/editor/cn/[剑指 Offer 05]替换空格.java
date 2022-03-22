//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 242 👎 0

package org.harden.simple.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-03-20 16:09:07
 */
class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        int i=0;
        while (i<s.length()){
            char c=s.charAt(i);
            if(c==' '){
                builder.append("%20");
            }else {
                builder.append(c);
            }
            i++;
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}