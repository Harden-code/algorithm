package org.harden.coder.hash;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/1/2 17:00
 * 文件说明：
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * </p>
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)&&!list.contains(i)) {
                list.add(i);
            }
        }
        int[] ints=new int[list.size()];
        for(int i=0;i< list.size();i++){
            ints[i]=list.get(i);
        }
        return ints;
    }
}
