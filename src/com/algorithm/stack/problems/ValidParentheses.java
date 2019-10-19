package com.algorithm.stack.problems;

// import java.util.Stack
import com.algorithm.stack.arraystack.ArrayStack;

// leetcode.com #20 Valid Parentheses
public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                return false;
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
