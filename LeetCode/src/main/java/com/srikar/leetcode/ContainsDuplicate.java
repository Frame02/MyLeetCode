/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
package com.srikar.leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        boolean result = false;
        
        if(nums.length > 1){
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for(int num: nums){
                if(!hashSet.add(num)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,1};
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println("Contains duplicate? " + cd.containsDuplicate(nums));
    }
    
}
