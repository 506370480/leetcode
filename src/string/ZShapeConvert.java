package string;

import java.util.ArrayList;
import java.util.List;

public class ZShapeConvert {
    public static void main(String[] args) {
        System.out.println(convert1("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",10));
    }
    public static String convert(String s, int numRows) {
        int len = (s.length()/(numRows*2-2)+1)*(numRows-1)+1;
        len = Math.max(len,numRows+1);
        char[][] chars = new char[numRows][len];
        int row = 0;
        int col = 0;
        for(int i=0;i<s.length();i++){
            col = i/(numRows*2-2)*(numRows-1);
            if((i-i/(numRows*2-2)*(numRows*2-2))%(numRows*2-2)>=numRows){
                col = col+(i-i/(numRows*2-2)*(numRows*2-2))%(numRows*2-2)-numRows+1;
            }
            chars[row][col] = s.charAt(i);
            if(i%(numRows*2-2)>=numRows-1){
                row--;
            }else{
                row++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if(chars[i][j]!=0){
                    sb.append(chars[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static String convert1(String s, int numRows){
        if(numRows==1) return s;
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++)  list.add(new StringBuilder());
        int flag = -1,i = 0;
        for(char c:s.toCharArray()){
            list.get(i).append(c);
            if(i==0||i==numRows-1) flag = -flag;
            i+=flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder.toString());
        }
        return sb.toString();
    }
}
