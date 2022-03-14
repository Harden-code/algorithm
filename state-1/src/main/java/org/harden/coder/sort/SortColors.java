package org.harden.coder.sort;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 16:08
 * 文件说明：
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻
 * ，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 */
public class SortColors {
    public static void sortColors(int[] nums) {
       for(int i=1;i<nums.length;i++){
            int value=nums[i];
            int j=i-1;
            for(;j>=0;j--){
                if(value<nums[j]){
                    //左移动
                    nums[j+1]=nums[j];
                }else {
                    break;
                }
            }
            nums[j+1]=value;
       }
    }

    public static void main(String[] args) {
        int[] a={2,0,2,1,1,0};
        sortColors(a);
    }
}
