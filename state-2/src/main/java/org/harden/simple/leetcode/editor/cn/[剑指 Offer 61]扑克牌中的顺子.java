//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 218 👎 0

package org.harden.simple.leetcode.editor.cn;
 /**
 * @author  junsenfu
 * @date 2022-03-22 20:24:59
 */
class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        int[] nums={0,0,1,2,5};
        System.out.println(solution.isStraight(nums));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        //先判断有没有重复的 把0给剔除
        boolean[] visit=new boolean[15];
        for (int i = 0; i < nums.length; i++) {
            //排除大小王情况
            if(nums[i]==0){
                continue;
            }
            if(!visit[nums[i]]){
                visit[nums[i]]=true;
            }else {
                //出现重复情况
                return false;
            }
        }
        //通过判断最大值和最小值的差值来确定是不是顺子
        //由于王可以随便当,因此判断需要注意；差值有几种情况 4,3,2
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //去除大小王
            if(nums[i]==0){
                continue;
            }
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        //[2,5)
        return max-min>=2&&max-min<5?true:false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}