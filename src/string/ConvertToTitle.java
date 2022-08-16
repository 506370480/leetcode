package string;

public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
    }
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber!=0){
            int t = (columnNumber-1)%26;
            sb.append((char) (t + 'A'));
            columnNumber = (columnNumber-1)/26;
        }
        return sb.reverse().toString();
    }
}
