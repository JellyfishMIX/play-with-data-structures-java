package com.algorithm.problems.kmp;

public class Kmp {
    private String mainStr;
    private String patternStr;

    // Getter & Setter

    public String getMainStr() {
        return mainStr;
    }

    public void setMainStr(String mainStr) {
        this.mainStr = mainStr;
    }

    public String getPatternStr() {
        return patternStr;
    }

    public void setPatternStr(String patternStr) {
        this.patternStr = patternStr;
    }

    /**
     * 生成next数组
     * @return next
     */
    public int[] generateNext() {
        int[] next = new int[patternStr.length()+1];
        next[0] = -1;
        int i = 0, j = -1;  // j设置为-1，没有特殊含义，便于写代码

        while (i < patternStr.length()) {
            if (j == -1 || patternStr.charAt(i) == patternStr.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }

    /**
     * 使用next数组进行字符匹配运算
     * @param next
     * @return resIndex
     */
    public int getWhere(int[] next) {
        int i = 0, j = 0;

        while (i < mainStr.length() && j < patternStr.length()) {
            if (j == -1 || mainStr.charAt(i) == patternStr.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == patternStr.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int where() {
        int[] next = this.generateNext();
        return this.getWhere(next);
    }
}
