package com.github.devraghav;

import java.util.EmptyStackException;
import java.util.Stack;

public class ValidParantheses {

    public boolean isValid(String s) {
        Stack<Character> paran = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                paran.push(ch[i]);
            } else {
                try {
                    char popOpenBracket = paran.pop();
                    if ((ch[i] == ')' && popOpenBracket != '(')
                            || (ch[i] == ']' && popOpenBracket != '[')
                            || ch[i] == '}' && popOpenBracket != '{') {
                        return false;
                    }
                } catch (EmptyStackException ee) {
                    return false;
                }

            }
        }
        return paran.isEmpty();
    }

    public static void main(String[] args) {
        ValidParantheses validParantheses = new ValidParantheses();
        System.out.println(validParantheses.isValid("()"));
        System.out.println(validParantheses.isValid("[]"));
        System.out.println(validParantheses.isValid("{}"));
        System.out.println(validParantheses.isValid("({})"));
        System.out.println(validParantheses.isValid("({}]"));
        System.out.println(validParantheses.isValid("(]"));
    }
}
