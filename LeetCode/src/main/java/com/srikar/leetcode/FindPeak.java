/*

A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
Note:
Your solution should be in logarithmic complexity.

*/
package com.srikar.leetcode;

/**
 *
 * @author vedantas
 */
public class FindPeak {
    public int findPeakElement(int[] nums){
        int index = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > nums[index]){
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,1};
        FindPeak fp = new FindPeak();
        System.out.println(fp.findPeakElement(nums));
    }
}
