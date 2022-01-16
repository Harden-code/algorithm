package org.harden.coder.tree;

import sun.security.krb5.internal.tools.Klist;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/16 15:59
 * 文件说明： 973. 最接近原点的 K 个点</p>
 */
public class KClosest {

    public int[][] kClosest(int[][] points, int k) {
        //利用大小堆，小顶堆装k个元素,第k个就是要找的元素
        // 返回最小
        Queue<int[]> max = new PriorityQueue<>((e1, e2) -> sqrt(e1[0], e1[1]) - sqrt(e2[0], e2[1]));
        // 返回最大
        Queue<int[]> min = new PriorityQueue<>((e1, e2) -> sqrt(e2[0], e2[1]) - sqrt(e1[0], e1[1]));
        for (int i = 0; i < points.length; i++) {
            //先放入min的 它poll出来的是最大值
            if(min.size()<k){
                min.offer(points[i]);
            }else {
                int target=sqrt(points[i][0],points[i][1]);
                int[] peek = min.peek();
                //比较最大的是否大于target
                if(target<sqrt(peek[0],peek[1])){
                    //拿出最大的
                    int[] poll = min.poll();
                    max.offer(poll);
                    min.offer(points[i]);
                }else {
                    max.offer(points[i]);
                }
            }
        }

        int[][] temp = new int[min.size()][2];
        int j = 0;
        while (!min.isEmpty()) {
            temp[j++] = min.poll();
        }

        return temp;

    }

    public int sqrt(int a, int b) {
        return Math.abs(a * a + b * b);
    }

    public static void main(String[] args) {
        int[][] a={{3,3},{5,-1},{-2,4}};
//        int[][] a = {{0, 1}, {0, -1}};
        KClosest kClosest = new KClosest();
        kClosest.kClosest(a, 2);

    }
}
