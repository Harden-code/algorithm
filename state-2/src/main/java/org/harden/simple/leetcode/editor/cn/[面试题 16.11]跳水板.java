//你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方
//法，生成跳水板所有可能的长度。 
//
// 返回的长度需要从小到大排列。 
//
// 示例 1 
//
// 输入：
//shorter = 1
//longer = 2
//k = 3
//输出： [3,4,5,6]
//解释：
//可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。 
//
// 提示： 
//
// 
// 0 < shorter <= longer 
// 0 <= k <= 100000 
// 
// Related Topics 数组 数学 👍 96 👎 0

package org.harden.simple.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  junsenfu
 * @date 2022-03-22 20:44:06
 */
class DivingBoardLcci{
    public static void main(String[] args) {
        Solution solution = new DivingBoardLcci().new Solution();
        solution.divingBoard(2,1118596,979);
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        //长短相等
        if(shorter==longer){
            return new int[]{longer*k};
        }
        //先用longer和shorter造出最大值和最小值
        int max=longer*k;
        int min=shorter*k;
        //longer-shorter的差去填充最小值
        int p=longer-shorter;
        //k+1 [max-min]是所有的 而他们只是相差k*p,也就是p的倍数
        int[] result=new int[k+1];
        int j=0;
        while (min<=max){
            result[j++]=min;
            min+=p;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}