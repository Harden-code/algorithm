package org.harden.everyday;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/22 10:36
 * 文件说明：1640. 能否连接形成数组 </p>
 */
public class CanFormArray {


    //以任意顺序 连接 pieces 中的数组以形成 arr
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            int[] val = pieces[i];
            map.put(val[0], val);
        }
        int i = 0;
        while (i < arr.length) {
            int val = arr[i];
            //没有
            int[] ints = map.get(val);
            if (Objects.isNull(ints)) {
                return false;
            }
            int j = 0;
            while (j < ints.length) {
                if (ints[j] != arr[i]) {
                    return false;
                }
                j++;
                i++;
            }

        }

        return true;
    }
}
