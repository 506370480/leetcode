package backTracking;

import java.util.LinkedList;
import java.util.List;

//���ȣ��������ŵ�������ֻҪ��ӽ�ȥ2n������
public class GenerateParenthesis {
    static List<String> res = new LinkedList<>();
    static String s = new String();

    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }

    //�±������������Ǳ����ⷨ���ܱ���
    public static List<String> generateParenthesis(int n) {
        dfs(n);
        return res;
    }

    public static void dfs(int n) {
        if (s.length() == 2 * n) {
            if (isValid(s)) {
                res.add(new String(s));
            }
            return;
        }
        for (char c : new char[]{'(', ')'}) {
            s += c;
            dfs(n);
            s = s.substring(0, s.length() - 1);
        }
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int m = 0;
        int n = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                m++;
            }
            if (chars[i] == ')') {
                n++;
            }
            if (n > m) {
                return false;
            }
        }
        if (m != n) {
            return false;
        }
        return true;
    }

    //�������ں����д���������ڵݹ�Ĺ����о��ж��Ƿ���valid
    public static List<String> generateParenthesis1(int n) {
        dfs1(n, 0, 0);
        return res;
    }

    public static void dfs1(int n, int open, int close) {
        if (s.length() == 2 * n && open == n) {
            res.add(new String(s));
            return;
        }
        if (open < close || open > n) {
            return;
        }
        for (char c : new char[]{'(', ')'}) {
            if (c == '(') {
                s += c;
                dfs1(n, open + 1, close);
                s = s.substring(0, s.length() - 1);
            } else {
                s += c;
                dfs1(n, open, close + 1);
                s = s.substring(0, s.length() - 1);
            }

        }
    }


}
