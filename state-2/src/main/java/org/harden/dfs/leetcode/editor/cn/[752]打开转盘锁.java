//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：无法旋转到目标数字且不被锁定。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 511 👎 0

package org.harden.dfs.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author junsenfu
 * @date 2022-07-18 21:28:13
 */
class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
//        String[] dead = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String[] dead ={"0000"};
                solution.openLock(dead, "8888");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> visited = new HashSet<>();
            if (isDead(deadends,"0000")) {
                return -1;
            }
            if (target.equals("0000")) {
                return 0;
            }
            int result = 1;
            //bfs
            Queue<String> queue = new ArrayDeque<>();
            queue.add("0000");
            visited.add("0000");
            while (!queue.isEmpty()) {
                int count = queue.size();
                //处理每层逻辑
                for (int i = 0; i < count; i++) {
                    String poll = queue.poll();
                    List<String> list = getAll(poll,deadends);
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).equals(target)) {
                            return result;
                        }
                        if (!visited.contains(list.get(j))) {
                            queue.add(list.get(j));
                            visited.add(list.get(j));
                        }
                    }
                }
                result++;
            }
            return -1;
        }

        private List<String> getAll(String source, String[] deadendsList) {
            List<String> result = new ArrayList<>();
            int[] dic = {1, -1};
            for (int k = 0; k < dic.length; k++) {
                //岔开0 1 2 3
                for (int i = 0; i < source.length(); i++) {
                    char[] chars = new char[4];
                    int value = source.charAt(i) - '0';
                    //j=0 j<0 第一个不填 j=1 j<1 第二个不填
                    for (int j = 0; j < i; j++) {
                        chars[j] = source.charAt(j);
                    }
                    for (int j = i + 1; j < source.length(); j++) {
                        chars[j] = source.charAt(j);
                    }
                    chars[i] = (char) ('0' + (value + 10 + dic[k]) % 10);
                    String s = new String(chars);
                    if (!isDead(deadendsList,s)) {
                        result.add(s);
                    }
                }
            }
            return result;
        }

        public boolean isDead(String[] deadends, String source) {
            for (int j = 0; j < deadends.length; j++) {
                if (source.equals(deadends[j])) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}