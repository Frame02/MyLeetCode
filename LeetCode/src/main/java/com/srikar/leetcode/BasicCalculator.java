/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srikar.leetcode;

/**
 *
 * @author vedantas
 */
public class BasicCalculator {

    int i = 0;
    public int calculate(String s) {
        i = 0;
        return evaluate(s, s.length());
    }

    private int evaluate(String expr, int endIndex) {
        boolean isLastTokenOperator = false;
        int leftOperand = 0;
        char operator = ' ';
        for (; i < endIndex; ++i) {
            char token = expr.charAt(i);
            if (token == ' ') {
            } else if (token == '(') {
                ++i;
                int result = evaluate(expr, endIndex);
                if (isLastTokenOperator) {
                    if (operator == '+') {
                        leftOperand = leftOperand + result;
                    } else {
                        leftOperand = leftOperand - result;
                    }
                } else {
                    leftOperand = result;
                }
                isLastTokenOperator = false;
            } else if (token == ')') {
                return leftOperand;
            } else if (token == '+') {
                operator = '+';
                isLastTokenOperator = true;
            } else if (token == '-') {
                operator = '-';
                isLastTokenOperator = true;
            } else {
                StringBuilder sb = new StringBuilder().append(token);
                for (++i; i < endIndex; ++i) {
                    Character ch = expr.charAt(i);
                    if (Character.isDigit(ch)) {
                        sb.append(ch);
                    } else {
                        --i;
                        break;
                    }
                }
                int operand = Integer.parseInt(sb.toString());
                if (isLastTokenOperator) {
                    if (operator == '+') {
                        leftOperand = leftOperand + operand;
                    } else {
                        leftOperand = leftOperand - operand;
                    }
                } else {
                    leftOperand = operand;
                }
                isLastTokenOperator = false;
            }
        }
        return leftOperand;
    }

    public static void main(String[] args) {
        String e1 = "1 + 1";
        BasicCalculator calc = new BasicCalculator();
        System.out.println(e1 + " = " + calc.calculate(e1));
    }
}
