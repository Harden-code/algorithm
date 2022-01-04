package org.harden.coder.hash;

import com.sun.org.apache.xerces.internal.xs.LSInputList;
import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/1 22:59
 * 文件说明：
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
 * ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }

        //用来存储nums中的 值和下标
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        //使下标递增，为了排除重复数据

        //使用两个for循环来求值
        for (int i = 0; i < nums.length; i++) {
            //排除重复数据 有重复数据直接跳过
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //与上面相同，用来排除重复数据  -1 -1
                if (j != i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (map.containsKey(-(nums[i] + nums[j]))) {
                    Integer value = map.get(-(nums[i] + nums[j]));
                    //特殊情况  -1 2 0 0
                    if ( j <= value) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[value]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
//        int[] a = {0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(a);
    }
}
