package math;

//��ʹ��ѭ�����ߵݹ�����ɱ���
public class isPowerOfThree {
    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree2(9);
        System.out.println(powerOfThree);
    }

    //������Լ�д�ģ��о�������
    public static boolean isPowerOfThree(int n) {
        while (n != 3) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return true;
    }

    //1.������Լ���˼·��һ���ģ����Ǳ��˼ҵĴ���ü��ѽ
    public static boolean isPowerOfThree1(int n){
        if(n>1){
            while(n%3==0){
                n/=3;
            }
        }
        return n==1;
    }

    //2.�ݹ�
    public static boolean isPowerOfThree2(int n){
        if(n<=0){
            return false;
        }
        if(n==1){
            //����Ǳ߽�����
            return true;
        }
        if(n%3==0&&isPowerOfThree(n/3)){
            return true;
        }
        return false;
    }
}
