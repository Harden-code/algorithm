package org.harden.coder.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/23 22:35
 * 文件说明：120. 三角形最小路径和 </p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标
 * 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标
 * i 或 i + 1 。
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * <p>
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * <p>
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        //dp[][]=triangle[i][j]+Min(p[i-1][j+1]+dp[i-1][j]+dp[i-1][j+1])
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = new ArrayList<>();
            dp.add(list);
        }
        Integer first = triangle.get(0).get(0);
        List<Integer> dpList = dp.get(0);
        dpList.add(first);


        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {

                Integer integer = triangle.get(i).get(j);
                //右上
                int a = Integer.MAX_VALUE;
                //左上
                int c = Integer.MAX_VALUE;
                //正对
                int b = Integer.MAX_VALUE;
                //0在范围内
                if (j - 1 >= 0) {
                    a = dp.get(i - 1).get(j - 1);
                }
                //越界
                if (j + 1 > list.size()) {
                    c = dp.get(i - 1).get(j + 1);
                }
                //越界
                if (dp.get(i - 1).size() > j) {
                    b = dp.get(i - 1).get(j);
                }

                int d = Math.min(a, b);
                int min = Math.min(c, d);
                List<Integer> list1 = dp.get(i);
                list1.add(integer + min);


            }
        }
        List<Integer> last = dp.get(dp.size() - 1);
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < last.size(); i++) {
            if(last.get(i)<min){
                min=last.get(i);
            }
        }
        Print.print(dp);
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> init = init();


        System.out.println(minimumTotal.minimumTotal(init));
    }

    private static List<List<Integer>> init() {

        List<List<Integer>> all = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);


        all.add(list1);
        all.add(list2);
        all.add(list3);
        all.add(list4);
        return all;
    }

}
