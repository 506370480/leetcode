package string;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'H','0'};

        //�±��ǳ�ʼ���ַ���������ַ�ʽ
        //1.����ǵ�һ�ַ�ʽ����ָ������
        char a[]={'1','2','3'};//���Բ�ָ��char���͵ĸ�����
        //�Ƽ�ʹ���±�����
        char[] b={'1','2','3'};
        //����ʹ������
        char[] c=new char[]{'1','2','3'};
        char[] d=new char[3];
        d[0]='1';
        d[1]='2';
        d[2]='3';

        reverseString(s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        if(s.length==0){
            return;
        }
        for(int i=0;i<s.length/2;i++){
            char temp = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }


    }
}
