package org.harden.everyday;


import java.util.*;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/4/1 17:20
 * 文件说明： 954. 二倍数对数组</p>
 * 对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回true；否则，返回 false。
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 */
public class CanReorderDoubled {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer> count=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        int zero=0;
        for (int i = 0; i < arr.length; i++) {
            //0过滤
            if(!count.containsKey(arr[i])&&arr[i]!=0){
                list.add(arr[i]);
            }
            //去0
            if(arr[i]==0){
                zero++;
                continue;
            }
            count.put(arr[i],count.getOrDefault(arr[i],0)+1);
        }

        //0只能是计数
        if((zero&1)==1){
            return false;
        }
        //1 2 4

        //绝对值排序 -2 -4 2 -4 可以避免符号的判断
        Collections.sort(list,(x,y)->Math.abs(x)-Math.abs(y));
        for (int i = 0; i < list.size(); i++) {
            int min=list.get(i);
            int max=min*2;
            int minCount=count.get(min);
            if(minCount==0){
                continue;
            }
            int maxCount=count.getOrDefault(max,0);
            if(maxCount==0||maxCount<minCount){
                return false;
            }else {
                //减少个数
                count.put(max,count.get(max)-minCount);
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, -4, 2, 4};
//        int[] nums = {2,1,1,4,8,8};
//        int[] nums = {-3, -5};
//        int[] nums = {2, 4, 0, 0, 8, 1};
//        int[] nums = {-2, -6, -3, 4, -4, 2};
        int[] nums = {-5, -2};
//        int[] nums={1,2,1,-8,8,-4,4,-4,2,-2};
        CanReorderDoubled canReorderDoubled = new CanReorderDoubled();
        System.out.println(canReorderDoubled.canReorderDoubled(nums));
    }



}
