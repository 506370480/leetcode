package other;

//  java����������λ�����
//  <<:�����������num << 1,�൱��num����2
//  >:�����������num >> 1,�൱��num����2
//  >>>:�޷������ƣ����Է���λ����λ����0����
//  �޷������ƵĹ���:���Է���λ��չ��0�����λ  �޷������������>>>ֻ��32λ��64λ��ֵ������
public class HammingWeight {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            if(((n>>>i)&1)==1){
                count++;
            }
        }
        return count;
    }

    //�±������ǱȽ�ȡ�ɵķ���
    public int hammingWeight1(int n){
        return Integer.bitCount(n);
    }
}
