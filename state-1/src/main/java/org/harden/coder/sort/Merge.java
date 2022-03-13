package org.harden.coder.sort;

/**
 * @author ：junsenfu
 * @date ：Created in 2021/12/26 14:48
 * 文件说明：
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 */
public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        if(n==0){
            return;
        }

        if(m==0){
            for(int i=0;i<A.length;i++){
                A[i]=B[i];
            }
            return;
        }
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int k=0;
        while (i <= m-1 && j <= n-1) {
            if(A[i]>B[j]){
                temp[k++]=B[j++];
            }else {
                temp[k++]=A[i++];
            }
        }
        while (i<= m-1){
            temp[k++]=A[i++];
        }
        while (j<=n-1){
            temp[k++]=B[j++];
        }
        for(i=0;i<A.length;i++){
            A[i]=temp[i];
        }
    }



    public static void main(String[] args) {
//        int[] a={1,2,3,0,0,0};
//        int[] b={2,5,6};
        int[] a={0};
        int[] b={1};
        Merge merger = new Merge();
        merger.merge(a,0,b,1);
    }
}
