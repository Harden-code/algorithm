package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/28 21:01
 * 文件说明：
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        int low = 0;
        int height = n;
        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                height = mid - 1;
            }
        }
        return -1;
    }
}

class GuessGame {
    public int guess(int num) {
        return -1;
    }
}
