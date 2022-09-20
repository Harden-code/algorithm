package org.harden.everyday;

import java.util.Arrays;

public class MaxLengthBetweenEqualCharacters {
    public static void main(String[] args) {
        MaxLengthBetweenEqualCharacters maxLengthBetweenEqualCharacters = new MaxLengthBetweenEqualCharacters();
        maxLengthBetweenEqualCharacters.maxLengthBetweenEqualCharacters("ojdncpvyneq");
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int result=-1;
        int[] map=new int[26];
        Arrays.fill(map,-1);
        for (int i = 0; i < s.length(); i++) {
            int index=s.charAt(i)-'a';
            if(map[index]==-1){
                map[index]=i;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int index=s.charAt(i)-'a';
            if(map[index]!=-1&&map[index]<i){
               result=Math.max(result,i-map[index]-1);
            }
        }

        return result;
    }
}
