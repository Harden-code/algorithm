package org.harden.coder.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/1 22:52
 * 文件说明：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //key 元素 value 元素下标
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        //特殊情况 1 2 4 9 target=8 如果4就会出现同一下标相加相等
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                //拿到相减的数，去hash里查找
                int value=map.get(target-nums[i]);
                if(value!=i){
                    return new int[]{i,value};
                }
            }
        }
        return null;
    }
}
