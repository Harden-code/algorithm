package org.harden.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/28 9:55
 * 文件说明： 面试题 17.09. 第 k 个数</p>
 * <p>
 * 3  5  7
 * 1，3，5，7，9，15，21。
 * min(3^a * 5^b * 7^c)
 * 0 1 2 3 4
 */
public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        //利用堆每次都返回最小 在*nums[] 去重
        //小顶堆
        Queue<Long> queue = new PriorityQueue<>();
        //大顶堆
        List<Long> list = new ArrayList<>();
        queue.add(1L);
        list.add(1L);
        int[] nums = {3, 5, 7};

        int count = 1;
        //count必须要到k 因为可能出现前面的乘小的 没被利用到
        //81 *3
        while (count <= k) {
            //返回最小
            Long peek = queue.poll();
            //再用最小的乘 在放入堆中
            //出现重复 3 5 7
            // poll 3 * 3 push 9
            // poll 3 * 5 push 15
            // poll 3 * 5 push 21

            // poll 5 * 3 push 15
            // poll 5 * 5 push 25
            // poll 5 * 7 push 35
            //每次都必须是最优的
            for (int i = 0; i < nums.length; i++) {
                long dump = peek;
                dump *= nums[i];
                if (list.contains(dump)) {
                    continue;
                }
                queue.add(dump);
                list.add(dump);
            }
            count++;
        }
        list.sort(Long::compareTo);
        return list.get(k - 1).intValue();
    }

    public int getKthMagicNumber_plus(int k) {
        int[] nums = {3, 5, 7};
        //小顶堆
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        queue.add(1L);
        seen.add(1L);
        int result = 0;
        //利用堆生成数据
        //不能= 因为前面已经add 1
        for (int i = 0; i < k; i++) {
            //每次弹出都是最优解
            long poll = queue.poll();
            result = (int) poll;
            //利用优先级队列生成 不同状态的值
            for (int num : nums) {
                long temp = poll;
                temp *= num;
                if (seen.add(temp)) {
                    queue.add(temp);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        GetKthMagicNumber get = new GetKthMagicNumber();
        System.out.println(get.getKthMagicNumber_plus(23));
    }
}
