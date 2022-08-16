package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FindWords {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"omk"})));
    }

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String[] key = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        boolean bool = true;
        for (String word : words) {
            String word1 = word.toLowerCase();
            for (int j = 0; j < 3; j++) {
                if (key[j].indexOf(word1.charAt(0)) != -1) {
                    for (int i = 1; i < word1.length(); i++) {
                        if(key[j].indexOf(word1.charAt(i)) == -1){
                            bool = false;
                            break;
                        }
                    }
                }
            }
            if(bool) list.add(word);
            bool = true;
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
