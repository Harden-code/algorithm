//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 1141 👎 0

package org.harden.hash.leetcode.editor.cn;

import java.util.*;

/**
 * @author  junsenfu
 * @date 2022-05-18 22:48:16
 */
class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> hash=new HashMap<>();
        //strs[i] 仅包含小写字母
        for (int i = 0; i < strs.length; i++) {
            String key = toHast(strs[i]);
            if(hash.containsKey(key)){
                List<String> list = hash.get(key);
                list.add(strs[i]);
            }else {
                List<String> list =new ArrayList<>();
                list.add(strs[i]);
                hash.put(key,list);
            }
        }
        for (Map.Entry<String, List<String>> entry : hash.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private String toHast(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}