package string;

public class StrStr {
    public static void main(String[] args) {
        int i = strStr1("mississippi", "issipi");
        System.out.println(i);
    }

    //��������Լ��ķ���������ѭ�����о����Ӻû��ң��������Ǻܶ�û�п��ǵ��������������Լ�һֱ��ԭ���Ĵ��������޲����ģ����ϵ�debug���ܷ��ֵ��������������

    public static int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        for(int i=0;i<haystack.length();){
            for(int j=0;j<needle.length();){
                if(haystack.charAt(i)==needle.charAt(j)){
                    i++;
                    j++;
                }else {
                    i=i-j+1;
                    j=0;
                    break;
                }
                if(j==needle.length()){
                    return i-needle.length();
                }
                if(i==haystack.length()){
                    return -1;
                }
            }
        }
        return -1;

    }

    //�±�����������˵ķ�����û��Ҫ������ѭ�������ҿ�����ǰ����ָ��Խ��������
    public static int strStr1(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
       int i=0;
        int j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
            if(j==needle.length()){
                return i-j;
            }
        }
        return -1;

    }
}
