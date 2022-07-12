//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1234 👎 0

package org.harden.dump.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author junsenfu
 * @date 2022-06-22 21:54:11
 */
class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        int[] nums={1,1,1,2,2,3};
        solution.topKFrequent(nums,2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Ele{
            private int key;

            private int value;

            Ele(int key,int value){
                this.key=key;
                this.value=value;
            }
        }
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            }
            //小顶堆 存kge
            PriorityQueue<Ele> dump=new PriorityQueue<>((t1,t2)->t1.value-t2.value);
            int[] result = new int[k];
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if(dump.size()<k){
                    dump.add(new Ele(entry.getKey(),entry.getValue()));
                }else{
                    Ele peek = dump.peek();
                    if(peek.value<entry.getValue()){
                        dump.poll();
                        dump.add(new Ele(entry.getKey(),entry.getValue()));
                    }
                }
            }
            int i=0;
            while (!dump.isEmpty()){
                Ele poll = dump.poll();
                result[i++]=poll.key;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}