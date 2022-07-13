//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 👍 584 👎 0

package org.harden.hash.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  junsenfu
 * @date 2022-05-18 22:43:53
 */
class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> hash=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(hash.containsKey(t.charAt(i))){
                if(hash.get(t.charAt(i))!=null&&hash.get(t.charAt(i))-1>0){
                    hash.put(t.charAt(i), hash.getOrDefault(t.charAt(i), 0) -1);
                }else {
                    hash.remove(t.charAt(i));
                }
            }else {
                return false;
            }

        }
        return hash.size()==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}