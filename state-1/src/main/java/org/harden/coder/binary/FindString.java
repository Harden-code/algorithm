package org.harden.coder.binary;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/28 23:47
 * 文件说明：
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class FindString {
    public int findString(String[] words, String s) {
        int low = 0;
        int height = words.length - 1;

        while (low <= height) {
            int mid = low + (height - low) / 2;
            if (words[mid].equals(s)) {
                return mid;
            } else if (compare(words, s, mid)) {
                height = mid - 1;
                while (mid > 0 && words[mid] == "") {
                    mid--;
                }
                if (mid == 0 && words[mid].equals(s)) {
                    return 0;
                }else if(mid == 0){
                    return -1;
                }
            } else {
                low = mid + 1;
                while (mid < words.length && words[mid] == "") {
                    mid++;
                }
                if (mid == words.length - 1) {
                    return -1;
                }
            }

        }
        return -1;
    }

    public boolean compare(String[] words, String s, int mid) {
        while (mid < words.length - 1 && words[mid] == "") {
            mid++;
        }
        if (words[mid].equals("")) {
            return false;
        }
        return words[mid].charAt(0) > s.charAt(0);
    }

    public static void main(String[] args) {
        String[] s = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        FindString findString = new FindString();
        System.out.println(findString.findString(s, "dad"));
    }
}
