package array;
//�����������Ҫ��
//1.����ָ�붼Ҫʹ��long����Ϊ����ָ��ƽ���ĺͿ��ܻᳬ��int�ķ�Χ
//2.���ж��Ƿ��Ǵ���c,���ڵĻ�fast--���������ܱ�֤˫ָ����һ����ȷ��
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum1(1000));
    }
    public static boolean judgeSquareSum1(int c) {
        int slow = 0;
        int fast = (int)Math.sqrt(c);
        while(fast*fast+slow*slow!=c){
            if(fast*fast+slow*slow<c){
                slow++;
            }else{
                fast--;
            }
            if(fast<slow){
                return false;
            }
        }
        return true;
    }
    public static boolean judgeSquareSum(int c) {
        long slow = 0;
        long fast = (long)Math.sqrt(c);
        while(fast*fast+slow*slow!=c){
            if(fast*fast+slow*slow>c){
                fast--;
            }else{
                slow++;
            }
            if(fast<slow){
                return false;
            }
        }
        return true;
    }
}

