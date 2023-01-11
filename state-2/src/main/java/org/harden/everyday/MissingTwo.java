package org.harden.everyday;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/26 10:41
 * 文件说明：面试题 17.19. 消失的两个数字 </p>
 */
public class MissingTwo {

    /**
     * [2,3,5,6]
     *        3  4  5  6  index-1-2
     *        数组映射关系 下标0是3开始 所有需要记录1 和 2
     * 输入: [-2,3,-5,-6] //负号代表 数组里数有
     * 输出: [1,4]
     */
    public int[] missingTwo(int[] nums) {

        //最小 数组从3开始 状态标记法
        if (nums.length == 1 && nums[0] == 1) {
            return new int[]{2, 3};
        }

        //总数 len+2 nums[i]-1 去找对应下标
        int[] result = new int[2];

        //把nums[i]-1下标对应的值改成负数,说明num[i]的元素在nums中
        for (int i = 0; i < nums.length; i++) {
            //从-2 映射数组从3开始
            //前面的转换后成负数
            int index = Math.abs(nums[i]) - 3;
            if (index >= 0 && index <= nums.length - 1) {
                nums[index] *= -1;
            }
        }

        //记录是否有1和2
        boolean one = false, two = false;

        int indexR = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            //表示没有
            if (value > 0) {
                int v = i + 3;
                result[indexR++] = v;
            }
            int abs = Math.abs(value);
            if (1 == abs) {
                one = true;
            }
            if (2 == abs) {
                two = true;
            }
//            min = Math.min(abs, min);
        }

        if (!one) {
            result[indexR++] = 1;
        }
        if (!two) {
            result[indexR] = 2;
        }

//        if (min == 2) {
//            result[indexR] = 1;
//        }
//        if (min == 3) {
//            return new int[]{1, 2};
//        }

        return result;
    }

    public static void main(String[] args) {
        MissingTwo missingTwo = new MissingTwo();
        int[] nums = {2, 5, 6, 4};
        missingTwo.missingTwo(nums);
    }
}
