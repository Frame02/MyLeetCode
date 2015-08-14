/*

 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 

 */
package com.srikar.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author vedantas
 */
public class Permutations {

    private List<List<Integer>> permList = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        //Convert int array to Integer array
        Integer[] numArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numArr[i] = nums[i];
        }
        // Guard against empty array
        if (nums.length >= 1) {
            generate(numArr, nums.length);
        }
        return permList;
    }

    // This implements Heap's Algorithm to generate permutations
    private void generate(Integer[] nums, int n) {
        if (n == 1) {
            permList.add(new ArrayList(Arrays.asList(nums)));
        } else {
            for (int i = 0; i < n - 1; ++i) {
                //  generate the (N − 1)! permutations of the first N − 1 elements
                generate(nums, n - 1);
                //  if n is even, we can switch the i th element and the last one
                if (n % 2 == 0) {
                    swap(nums, i, n - 1);
                } else {
                    // if n is odd, we switch the first element and the last one
                    swap(nums, 0, n - 1);
                }
            }
            generate(nums, n - 1);
        }
    }

    private void swap(Integer[] nums, int i, int j) {
        Integer tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> permList = permutations.permute(nums);
        for (List<Integer> perm : permList) {
            System.out.println(perm);
        }
    }

}
