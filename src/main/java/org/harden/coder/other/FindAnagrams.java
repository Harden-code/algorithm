package org.harden.coder.other;

import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/3/10 16:55
 * 文件说明：438. 找到字符串中所有字母异位词 </p>
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {
    /**
     * 因为字符串中的字符全是小写字母，可以用长度为26的数组记录字母出现的次数
     * 设n = len(s), m = len(p)。记录p字符串的字母频次p_cnt，和s字符串前m个字母频次s_cnt
     * 若p_cnt和s_cnt相等，则找到第一个异位词索引 0
     * 继续遍历s字符串索引为[m, n)的字母，在s_cnt中每次增加一个新字母，去除一个旧字母
     * 判断p_cnt和s_cnt是否相等，相等则在返回值res中新增异位词索引 i - m + 1
     */
    public List<Integer> findAnagrams(String s, String p) {
        
        return null;
    }
}
