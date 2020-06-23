package com.algorithm.set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 文件相关操作
 *
 * @author JellyfishMIX
 * @date 2020/6/23 8:34 上午
 */
public class FileOperation {

    /**
     * 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
     *
     * @param filepath filepath
     * @param words 单词List
     */
    public static void readFile(String filepath, ArrayList<String> words) {
        if (filepath == null || words == null) {
            throw new IllegalArgumentException("filename is null or words is null");
        }

        Scanner scanner;

        try {
            File file = new File(filepath);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream), StandardCharsets.UTF_8);
                scanner.useLocale(Locale.ENGLISH);
            } else {
                throw new IllegalArgumentException("The specified file does not exists");
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File Not Found");
        }

        // 简单分词
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用
        if (scanner.hasNext()) {
            // \A和\z匹配的是整段输入
            String contents = scanner.useDelimiter("\\A").next();

            int start = FileOperation.firstCharacterIndex(contents, 0);
            for (int i = start + 1; i < contents.length(); ) {
                if (!Character.isLetter(contents.charAt(i)) || i == contents.length()) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }
    }

    /**
     * 寻找字符串s中，从start的位置开始的第一个字母字符的位置
     *
     * @param str   待查找str
     * @param start 查找开始位置
     * @return
     */
    private static int firstCharacterIndex(String str, int start) {
        for (int i = start; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                return i;
            }
        }
        return str.length();
    }

}
