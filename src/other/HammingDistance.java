package other;

public class HammingDistance {
    public static void main(String[] args) {
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }

    //�����������ӣ�10^6�Ķ����ƽ��Ϊ1100��ת��Ϊʮ���Ƽ�12��
    public static int hammingDistance(int x, int y) {
        //����ת��Ϊ�����ƣ�Ȼ��ʹ�������
        int i = x ^ y;
        return Integer.bitCount(i);
    }
}
