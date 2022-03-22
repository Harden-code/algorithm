//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 493 👎 0

package org.harden.simple.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junsenfu
 * @date 2022-03-20 15:28:00
 */
class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println((int)'0');
        System.out.println((int)'9');
        solution.isPalindrome("0P");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            //把所有字符转换成小写
            String str = s.toLowerCase();
            //把所有标点去掉只剩数字和字母
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                //小写字符
                if (c <= 122 && c >= 97) {
                    list.add(c);
                }
                //数字 必须要经过转换
                int k=c-'0';
                if (k >= 0 && k <= 9) {
                    list.add(c);
                }
            }
            int i=0;
            int j=list.size()-1;
            while (i<j){
                if(list.get(i)!=list.get(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}