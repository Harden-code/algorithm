package org.harden.everyday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import java.util.Set;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/15 11:12
 * 文件说明：672. 灯泡开关 Ⅱ </p>
 */
public class FlipLights {
    /**
     * 1-3 全部开
     * <p>
     * 输入：n = 3, presses = 1
     * 输出：4
     * 解释：状态可以是：
     * - 按压开关 1 ，[关, 关, 关]
     * - 按压开关 2 ，[关, 开, 关]
     * - 按压开关 3 ，[开, 关, 开]
     * - 按压开关 4 ，[关, 开, 开]
     *
     * 规律题
     */
    public int flipLights(int n, int presses) {
        int[] path = new int[n + 1];
        //0 开
        Arrays.fill(path, 0);
        Set<String> result = new HashSet<>();
        if(presses>100) presses= (int)Math.round(presses*0.1/2);
        dfs_(result, path, presses, 0);
        return result.size();
    }

    private void dfs_(Set<String> result, int[] path, int presses, int k) {
        if (k == presses || (presses>100 && k > presses*0.1)) {
            //计算
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < path.length; i++) {
                builder.append(path[i]);
            }
            result.add(builder.toString());
            return;
        }

        //4种方法
        for (int index = 0; index < 4; index++) {
            if (index == 0) {
                //第一种方法 全反
                for (int i = 1; i < path.length; i++) {
                    path[i] ^= 1;
                }
                dfs_(result, path, presses, k + 1);
                for (int i = 1; i < path.length; i++) {
                    path[i] ^= 1;
                }
            }
            if (index == 1) {
                //第二种方法 偶数
                int i = 2;
                while (i < path.length) {
                    path[i] ^= 1;
                    i += 2;
                }
                dfs_(result, path, presses, k + 1);
                i = 2;
                while (i < path.length) {
                    path[i] ^= 1;
                    i += 2;
                }

            }
            if (index == 2) {
                //第三种方法 奇数
                int i = 1;
                while (i < path.length) {
                    path[i] ^= 1;
                    i += 2;
                }
                dfs_(result, path, presses, k + 1);
                i = 1;
                while (i < path.length) {
                    path[i] ^= 1;
                    i += 2;
                }
            }
            if (index == 3) {
                //第四种方法 3*i+1
                int i = 0;
                while ((3 * i + 1) < path.length) {
                    path[3 * i + 1] ^= 1;
                    i++;
                }
                dfs_(result, path, presses, k + 1);
                i = 0;
                while ((3 * i + 1) < path.length) {
                    path[3 * i + 1] ^= 1;
                    i++;
                }
            }

        }
    }


    public static void main(String[] args) {
        FlipLights flipLights = new FlipLights();
        flipLights.flipLights(100, 50);

    }
}
