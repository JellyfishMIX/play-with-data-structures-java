package com.algorithm.problems.kmp;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kmp kmp = new Kmp();

        // // 预设演示
        // kmp.setMainStr("ababababca");
        // kmp.setPatternStr("abababca");

        // 手动输入
        System.out.print("请输入主字符串：");
        String mainStr = input.nextLine();
        kmp.setMainStr(mainStr);
        System.out.print("请输入模式字符串：");
        String patternStr = input.nextLine();
        kmp.setPatternStr(patternStr);

        int resIndex = kmp.where();
        if (resIndex != -1) {
            System.out.println("模式字符串在主字符串的第" + (resIndex+1) + "个字母处，开始匹配");
        } else {
            System.out.println("抱歉，主串中未找到与模式字符串匹配的子串");
        }
    }
}
