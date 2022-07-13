//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 532 👎 0

package org.harden.tree.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author junsenfu
 * @date 2022-06-20 21:13:05
 */
class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        int[] ints = {4, 8, 6, 12, 16, 14, 10};
//        int[] ints = {1,6,3,2,5};
        solution.verifyPostorder(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean result = true;

        public boolean verifyPostorder(int[] postorder) {
            int[] inorder = Arrays.copyOf(postorder, postorder.length);
            Arrays.sort(inorder);
            verify(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
            return result;
        }

        private int verify(int[] inorder, int i, int j, int[] postorder, int p, int q) {
            if (i > j) {
                return -1;
            }
            if (!result) {
                return -1;
            }
            //通过后续遍历倒数第二个找头节点
            int head = postorder[q];
            int k = i;
            while (inorder[k] != head) {
                if (inorder[k] > head) {
                    result = false;
                    return -1;
                }
                k++;
            }
            //**求边界
            int leftSize = k - i;
            //超出边界
            if (k > j) {
                result = false;
            }
            int left = verify(inorder, i, k - 1, postorder, p, p + leftSize - 1);
            //中点pass
            int right = verify(inorder, k + 1, j, postorder, p + leftSize, q - 1);

            if (result && (left != -1 && left > head) || (right != -1 && head > right)) {
                result = false;
                return -1;
            }
            return head;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}