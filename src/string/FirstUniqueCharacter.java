package string;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        int i = firstUniqChar1("leetcode");
        System.out.println(i);
    }

    //这个是自己写的，增加了两个for四个if，需要考虑边界条件才是
    //如果不考虑边界的情况，会导致像无头苍蝇一样乱撞
    //要积累各种api的使用的方案
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

    //这个也是两次遍历，但是是先统计每个字符出现的个数， 当找到出现的次数为1的时候直接返回
    public static int firstUniqChar1(String s){
        int count[] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //这种使用ascll的方式就很巧妙
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
