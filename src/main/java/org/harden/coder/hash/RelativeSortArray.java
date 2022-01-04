package org.harden.coder.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 17:19
 * 文件说明：
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        //用来存储arr1的元素，key 值 value 个数
        //在遍历arr2 根据出现插入
        Map<Integer,Integer> map=new HashMap<>();
        for (int i : arr1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr2.length;i++){
            int value = arr2[i];
            if (map.containsKey(value)) {
                //个数
                Integer integer = map.get(value);
                //因为从1开始
                for(int j=0;j<integer;j++){
                    list.add(value);
                }
                //删除
                map.remove(value);
            }
        }
        //剩余元素
        int[] temp=new int[map.size()];
        int j=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            temp[j++]=entry.getKey();
        }
        Arrays.sort(temp);
        for (int i : temp) {
            Integer integer = map.get(i);
            for(j=0;j<=integer;j++){
                list.add(i);
            }
        }
        int[] ints=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ints[i]=list.get(i);
        }
        return ints;
    }
}
