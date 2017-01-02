package stack;

import java.util.Stack;

/**
 * Created by xuanwang on 1/1/17.
 */
/*
Given a string containing just the characters
'(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order,
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(s.charAt(i));
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(')
                            return false;
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{')
                            return false;
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[')
                            return false;
                        break;
                }
            }
            return stack.isEmpty();
        }

}
