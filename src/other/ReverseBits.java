package other;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits1(0b11111111111111111111111111111101));
    }

    public static int reverseBits(int n) {
        String s = "";
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        while (sb.length() < 32) {
            sb.append("0");
        }
        if(n<0){
            s = "-"+sb.toString();
        }else{
            s = sb.toString();
        }
        return Integer.valueOf(s, 2);
    }

    public static int reverseBits1(int n){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n&1);
            n >>= 1;
        }
        return res;
    }

}
