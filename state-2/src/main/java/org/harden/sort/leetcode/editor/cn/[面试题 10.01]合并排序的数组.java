//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 排序 👍 141 👎 0

package org.harden.sort.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-04-25 21:38:18
 */
class SortedMergeLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int[] dump = new int[A.length];
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < m && j < n) {
                if (A[i] > B[j]) {
                    dump[k++] = B[j];
                    j++;
                } else {
                    dump[k++] = A[i];
                    i++;
                }
            }
            if (i < m) {
                for (; k < A.length; k++) {
                    dump[k] = A[i++];
                }
            }
            if (j < n) {
                for (; k < A.length; k++) {
                    dump[k] = B[j++];
                }
            }
            for (int i1 = 0; i1 < dump.length; i1++) {
                A[i1] = dump[i1];
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}