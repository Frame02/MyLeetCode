/*

 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 */
package com.srikar.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<String>();
        if (nums.length > 0) {
            int i = nums[0], j = nums[0], num;
            for (int k = 1; k < nums.length; ++k) {
                num = nums[k];
                if (num != (j + 1)) {
                    if (i != j) {
                        resultList.add(i + "->" + j);
                    } else {
                        resultList.add(Integer.toString(i));
                    }
                    i = j = num;
                } else {
                    ++j;
                }
            }

            if (i != j) {
                resultList.add(i + "->" + j);
            } else {
                resultList.add(Integer.toString(i));
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 4, 6};
        SummaryRanges sr = new SummaryRanges();
        List<String> resultList = sr.summaryRanges(nums);
        for (String result : resultList) {
            System.out.println(result);
        }
    }

}
