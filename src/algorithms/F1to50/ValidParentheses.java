/* -*- coding: UTF-8 -*- */
package algorithms.F1to50;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('{', '}');
        parentheses.put('[', ']');
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else {
                if (stack.isEmpty() || parentheses.get(stack.pollLast()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
