/*

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note: 
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?

 */
package com.srikar.leetcode;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result;
        if (nums.length > 0) {
            result = new int[nums.length - k + 1];
            result[0] = findMax(nums, 0, k - 1);
            for (int i = 1, j = k; j < nums.length; ++i, ++j) {
                if (result[i - 1] == nums[i - 1]) {
                    if (nums[j] > nums[i - 1]) {
                        result[i] = nums[j];
                    } else {
                        result[i] = findMax(nums, i, j);
                    }
                } else {
                    if (nums[j] > result[i - 1]) {
                        result[i] = nums[j];
                    } else {
                        result[i] = result[i - 1];
                    }
                }
            }
        }
        else{
            result = new int[0];
        }
        return result;
    }

    private int findMax(int[] nums, int i, int j) {
        int max = nums[i++];
        while (i <= j) {
            if (nums[i] > max) {
                max = nums[i];
            }
            ++i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] result = swm.maxSlidingWindow(nums, 3);
        System.out.print("[ ");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
}
