package com.srikar.leetcode;

import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new java.util.ArrayList<List<Integer>>();
        java.util.Arrays.sort(nums);
        final int p = nums.length - 3;
        final int q = nums.length - 2;
        final int s = nums.length - 1;
        for (int i = 0; i <= p; ++i) {
            for (int j = i + 1; j <= q; ++j) {
                int k = binSearch(j + 1, s, nums, -(nums[i] + nums[j]));
                if (k != -1) {
                    resultList.add(java.util.Arrays.asList(nums[i], nums[j], nums[k]));
                }
                // To avoid duplicate triplet
                while ((j + 1) < nums.length && nums[j] == nums[j + 1]) {
                    ++j;
                }
            }
            // To avoid duplicate triplet
            while ((i + 1) < nums.length && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return resultList;
    }

    private int binSearch(int i, int j, int[] nums, int element) {
        while (i <= j) {
            int k = (i + j) >> 1;
            if (element < nums[k]) {
                j = k - 1;
            } else if (element > nums[k]) {
                i = k + 1;
            } else {
                return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> resultList = ts.threeSum(nums);
        for (List<Integer> tuple : resultList) {
            System.out.println(tuple);
        }
    }
}
