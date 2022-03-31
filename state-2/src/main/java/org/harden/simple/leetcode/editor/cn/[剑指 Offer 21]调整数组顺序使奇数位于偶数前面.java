//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums =[1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 209 👎 0

package org.harden.simple.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-03-18 23:03:44
 */
class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        //记录奇数位置 起始位置位-1 类似于快速排序
        //[1,2,3,4] i=0 q=-1 [0,0]奇数
        //[1,2,3,4] i=2 q=1  0,1]奇数
        int q=-1;
        int i=0;
        while (i<nums.length){
            if(nums[i]%2==1){
                q++;
                swap(nums,i,q);
            }
            i++;
        }
        return nums;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}