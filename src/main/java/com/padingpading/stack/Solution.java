package com.padingpading.stack;

import javafx.application.Preloader;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

/**
 * @author libin
 * @description
 * @date 2021/6/14
 */
public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c =='{') {
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if(c==')' && topChar!='(')
                    return false;
                if(c==']' && topChar!='[')
                    return false;
                if(c=='}' && topChar!='{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
