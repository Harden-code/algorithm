package org.harden.everyday;

import java.util.Arrays;

public class Decrypt {

    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] result = new int[code.length];
        if (k == 0) {
            Arrays.fill(result, 0);
        } else if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int val = 0;
                int index = i + 1;
                int p = 1;
                while (p <= k) {
                    int j = (index) % len;
                    val += code[j];
                    index++;
                    p++;
                }
                result[i] = val;
            }
        } else {
            k = Math.abs(k);
            //小于0
            for (int i = 0; i < code.length; i++) {
                int val = 0;
                int index = i - 1;
                int p = 1;
                while (p <= k) {
                    int j = (index + len) % len;
                    val += code[j];
                    index--;
                    p++;
                }
                result[i] = val;
            }
        }
        return result;
    }

    public int[] decrypt_plus(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int[] result = new int[code.length];
        //小于0
        int flag = k > 0 ? 1 : -1;
        k = Math.abs(k);
        int len = code.length;
        for (int i = 0; i < code.length; i++) {
            int val = 0;
            int j = 1;
            while (j <= k) {
                //前一个元素
                int next = i + flag * j;
                int index = flag < 0 ? (next + len) % len : (next) % len;
                val += code[index];
                j++;
            }
            result[i] = val;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arrs = {5, 7, 1, 4};
        Decrypt decrypt = new Decrypt();
        System.out.println(Arrays.toString(decrypt.decrypt_plus(arrs, -2)));

    }
}
