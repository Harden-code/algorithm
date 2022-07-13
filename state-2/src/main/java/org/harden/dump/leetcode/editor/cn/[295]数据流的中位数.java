//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 706 👎 0

package org.harden.dump.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author  junsenfu
 * @date 2022-06-22 22:21:13
 */
class FindMedianFromDataStream{
    public static void main(String[] args) {
        MedianFinder solution = new FindMedianFromDataStream().new MedianFinder();

    }
//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    private PriorityQueue<Integer> big;

    private PriorityQueue<Integer> small;


    private int count=0;

    public MedianFinder() {
        //小顶堆放后面数
        //大顶堆放前面的数 另外大顶堆要比小顶堆多一位
        small=new PriorityQueue<>((t1,t2)->t1-t2);
        big=new PriorityQueue<>((t1,t2)->t2-t1);
    }
    
    public void addNum(int num) {
        count++;
        //当大顶堆是空 或者 num比big小
        if(big.isEmpty()||num< big.peek()){
            big.add(num);
        }else {
            small.add(num);
        }
        //big必须大
        while (small.size()> big.size()){
            Integer poll = small.poll();
            big.add(poll);
        }
        //-1 奇数在大顶堆
        while (small.size()<big.size()-1){
            Integer poll = big.poll();
            small.add(poll);
        }
    }
    
    public double findMedian() {
        //奇数
       if((count&1)==1){
           return big.peek();
       }else {
           return (double)(big.peek()+small.peek())/2;
       }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}