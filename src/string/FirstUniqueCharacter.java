package string;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        int i = firstUniqChar1("leetcode");
        System.out.println(i);
    }

    //������Լ�д�ģ�����������for�ĸ�if����Ҫ���Ǳ߽���������
    //��������Ǳ߽��������ᵼ������ͷ��Ӭһ����ײ
    //Ҫ���۸���api��ʹ�õķ���
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if(chars.length==1){
            return 0;
        }
        for(int i = 0;i<chars.length;i++){
            for(int j = 0;j<chars.length;j++){
                if(i==j){
                    continue;
                }
                if(chars[i]==chars[j]){
                    break;
                }
                if(j==chars.length-1){
                    return i;
                }
            }
        }
        return -1;

    }

    //���Ҳ�����α�������������ͳ��ÿ���ַ����ֵĸ����� ���ҵ����ֵĴ���Ϊ1��ʱ��ֱ�ӷ���
    public static int firstUniqChar1(String s){
        int count[] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //����ʹ��ascll�ķ�ʽ�ͺ�����
            count[chars[i]-'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(count[chars[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
