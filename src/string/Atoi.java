package string;
//�����д�˺ܾúܾã���Ҫ������û�п��ǵ�ָ��Խ����쳣��û�п��ǵ����ֵ��߼�֮��Ĺ�ϵ
//���и���ϸ�ڣ�Խ��Խ�࣬�����Ҫ�úõ��ܽ�
//�����ж�intԽ����߼�Ҳ��Ҫѧϰ
public class Atoi {
    public static void main(String[] args) {
        myAtoi("  -0012a42");
        System.out.println(myAtoi("   -42"));
    }


    public static int myAtoi(String s) {
        //1.ȥ��ǰ���ո�
        int index = 0;
        for (; index < s.length(); index++) {
            if (s.charAt(index) != ' ') {
                break;
            }
        }
        if (index >= s.length()) {
            return 0;
        }
        int flag = 1;
        if (s.charAt(index) == '-') {
            flag = -1;
            index++;
            if (index >= s.length()) {
                return 0;
            }
            if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                return 0;
            }
        }
        if (s.charAt(index)  ==     '+') {
            index++;
            if (index >= s.length()) {
                return 0;
            }
            if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                return 0;
            }
        }
        //int start = index;
        int temp = 0;
        int result = 0;
        for (; index < s.length(); index++) {
            if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                return result;
            }
            while (s.charAt(index) - '0' >= 0 && s.charAt(index) - '0' <= 9) {
                //����ǳ��ı��˵Ĵ��룬�ж��Ƿ�Խ��Ĳ���������ѧϰ����
                temp = result;
                result = result * 10 + (s.charAt(index) - '0');
                //Խ����
                if (result / 10 != temp) {
                    if (flag > 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                index++;
                if (index >= s.length()) {
                    break;
                }
                if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                    return result*flag;
                }
            }
        }
        return result*flag;
//        if (start == index) {
//            return 0;
//        }

        //���ﲻ��ֱ��ʹ��parseint����Ϊ���г������ֵ��ֵ���ͻ�ʧЧ��
        //int num = Integer.parseInt(s.substring(start, index));
        //return num * flag;
    }
}
