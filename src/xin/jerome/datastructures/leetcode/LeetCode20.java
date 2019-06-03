package xin.jerome.datastructures.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode-20 有效的括号
 *
 * @author Jerome Zhu
 * @since 2018.10.23 21:14
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')','(');
        mappings.put(']','[');
        mappings.put('}','{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(mappings.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if(top != mappings.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                // 首先判断栈里面是否还有元素
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        LeetCode20 leetCode20 = new LeetCode20();
        System.out.println(leetCode20.isValid(s));
    }
}
