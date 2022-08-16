package string;
/*
����һ�� 32 λ���з������� x �����ؽ� x �е����ֲ��ַ�ת��Ľ����
* */

//ע�������32λ����˵һ����32λ�����֣�
//����ָ����-2,147,483,648 --2,147,483,647֮������ֲ�����32λ
//Math.abs(-2147483648)=-2147483648��java�е�һ��С���⣩��Ϊ�������ֻ��2��31�η���һ


import java.util.ArrayList;
import java.util.List;

public class IntegerInversion {
    //1.ʹ��int[] s = new int[32];�����NumberFormatException����쳣��������int�ķ�Χ
    //2.int���ʹ洢��Χ��-2,147,483,648 --2,147,483,647�����Ľ���ǲ���ʹ��int��
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse2(int x){
        if(x==0||x==Integer.MIN_VALUE){
            return 0;
        }
        //�����ǲο������˵Ĵ���
        int flag = x>0 ? 1:-1;
        x=Math.abs(x);

        //������ת�ַ����������ֵ���бȽϣ�������ͬ�����λ�ø���
        //1��StringBuffer �� StringBuilder �еķ����͹�����ȫ�ǵȼ۵ģ�
        //2��ֻ��StringBuffer �еķ����󶼲����� synchronized �ؼ��ֽ������Σ�������̰߳�ȫ�ģ�
        //�� StringBuilder û��������Σ����Ա���Ϊ���̲߳���ȫ�ġ�
        //3���ڵ��̳߳����£�StringBuilderЧ�ʸ��죬��Ϊ������Ҫ���������߱����̰߳�ȫ
        //��StringBuffer��ÿ�ζ���Ҫ�ж�����Ч����Ը���(���̻߳�����synchronized�ᷢ������ƫ�򣬲�û�����ľ��������ƫ�������ܽϺ�)
        String s = new StringBuffer(String.valueOf(x)).reverse().toString();
        String maxLength = String.valueOf(Integer.MIN_VALUE);
        if(s.length()>=maxLength.length()&&s.compareTo(maxLength)>0){
            return 0;
        }else {
            return Integer.valueOf(s)*flag;
        }
    }
    public static int reverse(int x) {
        //�±����Լ���д�Ĵ��룬�ܶ����̫���ˣ������
        List<Integer> list = new ArrayList<>();
        int flag= 1;
        if(x==0){
            return 0;
        }
        if(x<0){
            flag = -1;
            x=-x;
        }
        while(x!=0){
            list.add(x%10);
            x=x/10;
        }
        //StringBuilder������һ���ɱ���󣬿���Ԥ���仺������
        // ������StringBuilder�������ַ�ʱ�����ᴴ���µ���ʱ����(�����ֱ��ʹ�á�+��)
        StringBuilder strNum = new StringBuilder();
        for(int num:list){
            strNum.append(num);
        }
        int finalInt = Integer.parseInt(strNum.toString());
        return finalInt*flag;

    }
}
