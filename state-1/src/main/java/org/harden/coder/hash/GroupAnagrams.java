package org.harden.coder.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 16:28
 * 文件说明：
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String s=new String(c);
            if(map.containsKey(s)){
                List<String> strings = map.get(s);
                strings.add(str);
                continue;
            }
            List<String> strings=new ArrayList<>();
            strings.add(str);
            map.put(s,strings);
        }
        return new ArrayList<>(map.values());

    }
}
