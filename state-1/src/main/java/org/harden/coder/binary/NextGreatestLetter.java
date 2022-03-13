package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/28 21:09
 * 文件说明：
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，
 * 请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int height = letters.length - 1;
        return reverse(letters, 0, height, target);
    }

    public char reverse(char[] letter, int low, int height, char target) {
        if (low > height) {
            return letter[0];
        }
        int mid = low + (height - low) / 2;
        if (letter[mid] == target) {
            /**
             * ["c", "f", "j"]
             * "j"
             * 最大情况
             */
            if(mid==letter.length-1){
                return letter[0];
            }
            /**
             * e e e
             * f
             * 最小情况
             */
            if(mid==0){
               while (letter[mid]==target){
                   mid++;
               }
               return letter[mid];
            }
            // 相等情况
            return reverse(letter, mid + 1, height, target);
        } else if (letter[mid] > target) {
            if (mid == 0 || letter[mid - 1] <= target) {
                return letter[mid];
            } else {
                return reverse(letter, low, mid - 1, target);
            }

        } else {
            return reverse(letter, mid + 1, height, target);
        }
    }

    public static void main(String[] args) {
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
//        char[] chars={'c','f','g'};
        char[] chars={'e','e','e','e','e','e','e','n','n','n','n'};
        System.out.println(nextGreatestLetter.nextGreatestLetter(chars, 'e'));
    }
}
