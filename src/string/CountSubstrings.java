//package string;
//
//public class CountSubstrings {
//    public static void main(String[] args) {
//
//    }
//    public static int countSubstrings(String s) {
//        int len = s.length();
//        int count=0;
//        for (int i = 0; i < len; i++) {
//            count++;
//            char ch = s.charAt(i);
//            for (int j = 1; j < len/2; j++) {
//                if(i-j>=0&&s.charAt(i-j)==ch){
//                    count++;
//                    ch = s.charAt(i-j);
//                }
//                if(i+j<len&&s.charAt(i+j)==ch){
//                    count++;
//                    ch = s.charAt(i-j);
//                }
//            }
//        }
//    }
//}
