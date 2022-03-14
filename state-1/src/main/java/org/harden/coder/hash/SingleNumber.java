package org.harden.coder.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 16:51
 * 文件说明：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            //有重复就删除
            if(set.contains(num)){
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        Integer[] toArray = set.toArray(new Integer[0]);
        return set.size()!=1?0:toArray[0];
    }
}
