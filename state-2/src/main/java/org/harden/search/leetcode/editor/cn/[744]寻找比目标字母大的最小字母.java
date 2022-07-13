//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target
//请你寻找在这一有序列表里比目标字母大的最小字母。
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: letters = ['c', 'f', 'j']，target = 'a'
//输出: 'c'
// 
//
// 示例 2: 
//
// 
//输入: letters = ['c','f','j'], target = 'c'
//输出: 'f'
// 
//
// 示例 3: 
//
// 
//输入: letters = ['c','f','j'], target = 'd'
//输出: 'f'
// 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 10⁴ 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
// Related Topics 数组 二分查找 👍 221 👎 0

package org.harden.search.leetcode.editor.cn;

/**
 * @author junsenfu
 * @date 2022-05-06 22:15:36
 */
class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//        char[] chars = {'c','f','j'};
//        char[] chars={'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(solution.nextGreatestLetterBest(chars, 'a'));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int low = 0;
            int height = letters.length - 1;
            int value = target - 'a';
            while (low <= height) {
                //比目标字母大的最小字母
                int mid = low + (height - low) / 2;
                int i = letters[mid] - 'a';
                //
                if (i >= value) {
                    //
                    if (mid - 1 >= 0 && (letters[mid - 1] - 'a') <= value && i != value) {
                        return letters[mid];
                    } else if (mid == 0) {
                        //0 特殊情况 mid+1大于target且mid<=target前移动 用区间固定
                        if (mid + 1 < letters.length && letters[mid + 1] > target && letters[mid] <= target) {
                            return letters[mid + 1];
                        } else {
                            return letters[mid];
                        }
                    } else if ((letters[mid - 1] - 'a') <= value && i == value) {
                        low = mid + 1;
                    } else {
                        //mid>target
                        height = mid - 1;
                    }
//                    //char[0]==target
//                    if (mid == 0 && i == target) {
//                        low = mid + 1;
//                    } else if (mid - 1 >= 0 && ((letters[mid - 1] - 'a') <= value && i != value)) {
//                        //结果 前一个小于当前且当前不等于target
//                        return letters[mid];
//                    } else if (mid + 1 <= height && (letters[mid] - 'a') == value) {
//                        //e ,e , e, e, n ,n  e中相同 向前移动
//                        low = mid + 1;
//                    } else {
//                        //i>value
//                        height = mid - 1;
//                    }
                } else {
                    //mid小于target
                    low = mid + 1;
                }
            }
            return letters[0];
        }

        public char nextGreatestLetterBest(char[] letters, char target) {
            int low = 0;
            int height = letters.length - 1;
            int t = target - 'a';
            while (low <= height) {
                //先处理命中的
                int mid = low + (height - low) / 2;
                int value = letters[mid] - 'a';
                //比目标字母大的最小字母。=>letter[mid]>target 如果为=右边就会出现重复
                if (value > t) {
                    //mid已经不等于 所以上一个不会等于
                    if (mid == 0 || letters[mid - 1]-'a' <= t) {
                        return letters[mid];
                    } else {
                        height = mid - 1;
                    }
                } else {
                    //target>=value
                    low = mid + 1;
                }
            }
            return letters[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}