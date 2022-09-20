package org.harden.everyday;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 */
public class FrequencySort {

    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            //val->数量
            list.add(new int[]{key, map.get(key)});
        }
        //计算排序
        //数值大小排序
        Collections.sort(list, (a, b)->
             a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        int[] ans = new int[n];
        int idx = 0;
        for (int[] info : list) {
            while (info[1]-- > 0) ans[idx++] = info[0];
        }
        return ans;


    }

    //sb版本
    class P{
        public P(int val, int count) {
            this.val = val;
            this.count = count;
        }

        int val;

        int count;
    }
    public int[] frequencySort_(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            mapCount.put(val, mapCount.getOrDefault(val, 0) + 1);
            //最大

        }
        int[] result = new int[nums.length];
        if (mapCount.size() == nums.length) {
            int len = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[len - i];
            }
            return result;
        }

        int index=0;
        P[] ps=new P[mapCount.size()];
        for (Map.Entry<Integer, Integer> entry : mapCount.entrySet()) {
            ps[index++]=new P(entry.getKey(),entry.getValue());
        }

        Arrays.sort(ps, (a, b) -> a.count - b.count);
//        int[] result = new int[nums.length];
        index=0;
        for (int i = 0; i < ps.length; i++) {
            int val = ps[i].val;
            int count = ps[i].count;
            int j = i + 1;
            //找到最大i交换
            if (j < ps.length) {
                int mark=i;
                while (j < ps.length && count == ps[j].count) {
                    if (val <ps[j].val ) {
                        mark=j;
                        val=ps[j].val;
                    }
                    j++;
                }
                P p=ps[i];
                ps[i]=ps[mark];
                ps[mark]=p;
            }

            int k = ps[i].count;
            while (k > 0) {
                result[index++] = ps[i].val;
                k--;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 3, 2};
        FrequencySort frequencySort = new FrequencySort();
        int[] nums2 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        frequencySort.frequencySort(nums2);
    }
}
