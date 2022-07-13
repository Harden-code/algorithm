package org.harden.sort.leetcode.editor.cn;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei)
 * , determine if a person could attend all meetings.
 *
 * Input: [[0,30],[5,10],[15,20]] false
 * Input: [[7,10],[2,4]] true
 */
public class MeetingRooms {
    
    public boolean meetingRooms(int[][] intervals){
        sort(intervals);
        //可以直接省略 直接比
        Stack<int[]> stack=new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if(!stack.isEmpty()){
                int[] peek = stack.peek();
                if(peek[1]>intervals[i][0]){
                    return false;
                }
            }
            stack.push(intervals[i]);
        }
        return true;
    }
    
    private void sort(int[][] intervals){
        for (int i = 0; i < intervals.length; i++) {
            int j=i-1;
            int val=intervals[i][0];
            for (;j>=0;j--){
                if(val<intervals[j][0]){
                    swap(intervals,j,j+1);
                }else {
                    break;
                }
            }
        }
    }

    private void swap(int[][] ints,int i,int j){
        int[] temp=ints[i];
        ints[i]=ints[j];
        ints[j]=temp;
    }


}
