package org.harden.coder.dfs;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/2/16 20:53
 * 文件说明：1306. 跳跃游戏 III </p>
 * <p>
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。
 * 当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanReach {
    private boolean result;

    private boolean[] visit;

    int[] dic = {1, -1};

    public boolean canReach(int[] arr, int start) {

        for (int i = 0; i < arr.length; i++) {
            //0,3,0,6,3,3,4 防止重复的 并且要清除visit
            if (arr[i] == 0&&!result) {
                visit = new boolean[arr.length];
                dfs(start, i, arr);
            }
        }
        return result;
    }

    public void dfs(int start, int end, int[] arr) {
        //start end
        visit[start] = true;
        if (result) {
            return;
        }
        if (start == end) {
            result = true;
            return;
        }
        for (int i = 0; i < dic.length; i++) {
            int newIndex = start + dic[i] * arr[start];
            if (newIndex < 0 || newIndex >= arr.length || visit[newIndex]) {
                continue;
            }
            dfs(newIndex, end, arr);
        }
    }

    public static void main(String[] args) {
        CanReach canReach = new CanReach();
//        int[] arr = {3, 0, 2, 1, 2};
//        System.out.println(canReach.canReach(arr, 2));

        int[] arr1={0,3,0,6,3,3,4};
        System.out.println(canReach.canReach(arr1, 6));
    }
}
