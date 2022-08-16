package string;

public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res *=26;
            res +=(columnTitle.charAt(i)+1-'A');
        }
        return res;
    }
}
