package com.algorithm.stack.problems.infixexpstopostfixexps;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        InfixExpsToPostfixExps infixExpsToPostfixExps = new InfixExpsToPostfixExps();
        Scanner input = new Scanner(System.in);

        // // 测试"中缀式字符串使用队列储存"的效果
        // infixExpsToPostfixExps.testOutputInfixArray();

        // // 预设输入测试区
        // // infixExpsToPostfixExps.inputStr("6789+2*(3*(3-1*2+1))");
        // // infixExpsToPostfixExps.inputStr("5+2*(3*(3-1*2+1))");
        // infixExpsToPostfixExps.inputStr("670+9*3");

        // 手动输入区
        System.out.print("请输入一行中缀式运算符(操作数位数任意，可选操作符为'+', '-', '*', '/')：");
        String inputStr = input.nextLine();
        infixExpsToPostfixExps.inputStr(inputStr);

        // 执行区
        // System.out.println("中缀表达式字符串存储集合为");
        // infixExpsToPostfixExps.outputInfixArray();  // 打印中缀式字符串存储队列集合
        infixExpsToPostfixExps.toPostfixExps(); // 转化为后缀表达式
        System.out.println("----------------------------");
        infixExpsToPostfixExps.printPostfixExps(); // 打印后缀表达式postfixExps, 后缀表达式记录器postfixArray, 后缀栈postfixArrayStack，可选择打印。
        System.out.println("----------------------------");
        double res = infixExpsToPostfixExps.calcPostfixExps();  // 计算后缀表达式
        System.out.println("后缀表达式运算结果为：" + res);
    }
}
