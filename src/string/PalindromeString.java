package string;

import java.util.ArrayList;
import java.util.List;
//1.indexOf() �����ɷ���ĳ��ָ�����ַ���ֵ���ַ������״γ��ֵ�λ�á�
//���û���ҵ�ƥ����ַ����򷵻� -1,���ص���λ�ã�����������ط���ֵ��ʲô�����ֵ��ע�⡣

//2.��Ҫʹ��charAt()
public class PalindromeString {
    public static void main(String[] args) {
        String s = "race a car";
        boolean palindrome = isPalindrome3(s);
        System.out.println(palindrome);
    }
    //�±�����������Լ��ķ���������������ʽ��Ȼ��ͨ��ѭ���Ƚ�
    //����ʱ�临�Ӷȷǳ��ĸߣ���o(n)��������
    //String ����Ϊnull,��intĬ��ֵΪ0��Interger�Ż�Ϊnull
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s=s.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "");
        s=s.replaceAll("[\\s*|\t|\r|\n]", "");
        List list = new ArrayList();
        for(int i=0;i<s.length()/2;i++){
            s.charAt(1);
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }


    //2.������ʽ+�ַ�����ת
    public static boolean isPalindrome2(String s){
        s.replaceAll("[^0-9a-zA-Z]","").toLowerCase();
        String s1 = new StringBuffer(s).reverse().toString();
        return s.equals(s1);
    }

    //3.˫ָ�룬���������ַ�Ҫ������Ȼ������ж�
    //�������˫ָ�룬ֻ����������ʽȥ�������ַ��ˣ���˫ָ����������������ַ�
    public static boolean isPalindrome3(String s){
        if(s==null||s.length()==0){
            return true;
        }
        s.toLowerCase();
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            while(i<j&&!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j&&!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;


    }


}
