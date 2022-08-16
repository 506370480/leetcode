package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = isValid("]");
        System.out.println(valid);
    }

    //这个用栈感觉可以解决，但是如何实现栈？
    //这是是自己使用列表实现的
    public static boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                list.add(s.charAt(i));
            }else if((s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}')&&list.isEmpty()){
                return false;
            }
            else if ((s.charAt(i) == ')' && list.get(list.size() - 1) != '(')
                    || (s.charAt(i) == ']' && list.get(list.size() - 1) != '[')
                    || (s.charAt(i) == '}' && list.get(list.size() - 1) != '{')) {
                return false;
            } else {
                list.remove(list.size() - 1);
            }
        }
        if (list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //stack
    //add是继承自Vector的方法，返回值类型是boolean。
    //push是Stack自身的方法，返回值类型是参数类类型。
    //peek()函数返回栈顶的元素，但不弹出该栈顶元素。
    //pop()函数返回栈顶的元素，并且将该栈顶元素出栈。
    public static boolean isValid1(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char ch:chars){
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=ch){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
