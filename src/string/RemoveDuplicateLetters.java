package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("abacb"));
    }
    //去除重复字符，要求返回的字典序最小
    //如何使用单调栈？

    //维护一个map，里边是词频
    public static String removeDuplicateLetters(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && s.charAt(i) < stack.peek() &&!stack.contains(s.charAt(i))) {
                if (map.get(stack.peek()) == 0) {
                    break;
                }
                stack.pop();
            }
            if(!stack.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
