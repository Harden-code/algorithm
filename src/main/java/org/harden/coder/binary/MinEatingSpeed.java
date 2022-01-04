package org.harden.coder.binary;

import org.harden.coder.link.MiddleNode;

import java.util.Arrays;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/30 23:31
 * 文件说明：
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，
 * 将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，
 * 从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 0;
        int height = piles[piles.length - 1];

        while (low <= height) {
            //速度
            int mid = low + (height - low) / 2;
            //小时
            int hour = eat(piles, mid);
            if (hour <= h) {
                //速度最小 超时 防止溢出
                if (mid==1 || eat(piles, mid - 1) > h) {
                    return mid;
                } else {
                    //hour<h 过快减速
                    height = mid - 1;
                }
            } else {
                //时间大 加速
                low = mid + 1;
            }
        }
        return -1;
    }

    public int eat(int[] piles, int mid) {
        int result = 0;
        for (int i = 0; i < piles.length; i++) {
            //求余数
            result+=(piles[i]-1)/mid+1;
        }
        return result;
    }

    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        //6 3 5 1 4
//        int[] a = {30, 11, 23, 4, 20}; //5
//        System.out.println(minEatingSpeed.canFinish(a, 30));

//        int[] a={332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};

//        [312884470] 312884469
//        [312884470] 968709470
        int[] a = {312884470};

        System.out.println(minEatingSpeed.minEatingSpeed(a, 968709470));
    }
}
