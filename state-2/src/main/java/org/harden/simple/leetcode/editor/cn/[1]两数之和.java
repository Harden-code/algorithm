package org.harden.simple.leetcode.editor.cn;//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 13774 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class TwoSum {
    /**
     * 利用双指针 i j
     * 先对nums数组进行排序,从小到达头尾设置两个指针i,j
     * 指针指向的值大于目标值j--
     * 指针指向的值小于目标值i++
     * 同时复制一份数组出来记录i j原来位置的下标
     */
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (temp[i] + temp[j] > target) {
                //大于target,j--
                j--;
            } else if (temp[i] + temp[j] < target) {
                //小于target,i++
                i++;
            } else {
                //等于
                int p = Integer.MIN_VALUE;
                int q = Integer.MIN_VALUE;
                for (int k = 0; k < nums.length; k++) {
                    //重复情况[3,3]
                    if (p == Integer.MIN_VALUE && nums[k] == temp[i]) {
                        p = k;
                    }
                    if (nums[k] == temp[j]) {
                        q = k;
                    }
                }
                return new int[]{p, q};
            }
        }
        return new int[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
