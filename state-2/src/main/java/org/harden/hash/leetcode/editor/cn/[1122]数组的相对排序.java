//给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 示例 2: 
//
// 
//输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//输出：[22,28,8,6,17,44]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 数组 哈希表 计数排序 排序 👍 217 👎 0

package org.harden.hash.leetcode.editor.cn;

import java.util.*;

/**
 * @author  junsenfu
 * @date 2022-05-18 23:12:06
 */
class RelativeSortArray{
    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19} ;
        int[] arr2={2,1,4,3,9,6};
        solution.relativeSortArray(arr1,arr2);
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //存储不包含arr2
        Map<Integer,Integer> hash1=new HashMap<>();
        //arr2的元素个数
        Map<Integer,Integer> hash2=new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            hash2.put(arr2[i],0);
        }

        for (int i = 0; i < arr1.length; i++) {
            if(hash2.containsKey(arr1[i])){
                hash2.put(arr1[i],hash2.getOrDefault(arr1[i],0)+1);
            }else {
                hash1.put(arr1[i],hash1.getOrDefault(arr1[i],0)+1);
            }
        }
        List<Integer> list=new ArrayList<>();
        int i=0;
        for (Map.Entry<Integer, Integer> entry : hash1.entrySet()) {
            int value=entry.getValue();
            int key=entry.getKey();
            while (value>0){
                list.add(key);
                value--;
            }
        }
        //计算不包含arr2的
        int[] arr=new int[list.size()];
        for (int i1 = 0; i1 < arr.length; i1++) {
            arr[i1]=list.get(i1);
        }
        Arrays.sort(arr);

        int[] result=new int[arr1.length];
        i=0;
        int j=0;
        int len2=arr1.length-arr.length;
        while (i<len2){
            int key=arr2[j++];
            int value=hash2.get(key);
            while (value>0){
                result[i++]=key;
                value--;
            }

        }
        j=0;
        while (i<arr1.length){
            result[i++]=arr[j++];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}