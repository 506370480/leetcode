package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = isValid("]");
        System.out.println(valid);
    }

    //�����ջ�о����Խ�����������ʵ��ջ��
    //�������Լ�ʹ���б�ʵ�ֵ�
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
    //add�Ǽ̳���Vector�ķ���������ֵ������boolean��
    //push��Stack����ķ���������ֵ�����ǲ��������͡�
    //peek()��������ջ����Ԫ�أ�����������ջ��Ԫ�ء�
    //pop()��������ջ����Ԫ�أ����ҽ���ջ��Ԫ�س�ջ��
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
