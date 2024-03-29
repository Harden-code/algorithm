package org.harden.coder.hash;



import java.util.HashMap;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 15:37
 * 文件说明：
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 *
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/words-frequency-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class WordsFrequency {

    private Map<String,Integer> map;

    public WordsFrequency(String[] book) {
        map=new HashMap<>();
        for(int i=0;i<book.length;i++){
            if(map.containsKey(book[i])){
                map.put(book[i],map.get(book[i])+1);
            }else {
                map.put(book[i],1);
            }
        }
    }

    public int get(String word) {
        if(word!=null&&word.length()==0){
            return 0;
        }
        return map.getOrDefault(word,0);
    }

    public static void main(String[] args) {
        WordsFrequency wordsFrequency =
                new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        System.out.println(wordsFrequency.get("you"));
    }
}
