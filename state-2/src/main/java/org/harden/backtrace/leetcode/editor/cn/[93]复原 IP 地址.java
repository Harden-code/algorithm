//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 952 👎 0

package org.harden.backtrace.leetcode.editor.cn;

import javax.print.attribute.standard.PrinterURI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author junsenfu
 * @date 2022-07-06 22:30:43
 */
class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            backTrace(s, new ArrayList<>(), 0);
            return result;
        }

        private void backTrace(String s, List<String> path, int begin) {
            if (path.size() == 4) {
                String collect = path.stream()
                        .collect(Collectors.joining("."));
                //去掉3个点
                if (collect.length() - 3 == s.length()) {
                    result.add(collect);
                }
                return;
            }
            //每个阶段做决策=>截取几个
            for (int i = 1; i <= 3; i++) {
                if (begin + i > s.length()) {
                    return;
                }
                String substring = s.substring(begin, begin + i);
                if (isIp(substring)) {
                    path.add(substring);
                    backTrace(s, path, begin + i);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isIp(String ip) {
            if (ip.length() > 3) {
                return false;
            }
            if (ip.charAt(0) == '0' && ip.length() > 1) {
                return false;
            }
            int sum = 0;
            for (int i = 0; i < ip.length(); i++) {
                int value = ip.charAt(i) - '0';

                if (value >= 0 && value <= 9) {
                    sum = sum * 10 + value;
                } else {
                    //不是数字
                    return false;
                }

            }
            if (sum < 0 || sum > 255) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}