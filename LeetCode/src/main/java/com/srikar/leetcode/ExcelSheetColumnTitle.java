/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

*/
package com.srikar.leetcode;

import java.util.Scanner;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n){
        StringBuilder sb = new StringBuilder();
        int r;
        while(n != 0){
            --n;
            r = n % 26;
            sb.insert(0, Character.toString((char)(65 + r)));
            n /= 26;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
        while(true){
            System.out.print("Enter the number to be converted to Excel Sheet Column Title: ");
            int i = scanner.nextInt();
            System.out.println();
            if(i == -1)
                break;
            System.out.println(i + " = " + esct.convertToTitle(i));
        }
    }
}
