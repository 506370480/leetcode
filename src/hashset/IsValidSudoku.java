package hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer>[] rows = new HashMap[9];
        HashMap<Character, Integer>[] lines = new HashMap[9];
        HashMap<Character, Integer>[] boxs = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            lines[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Character ch = board[i][j];
                if (ch != '.') {
                    rows[i].put(ch, rows[i].getOrDefault(ch, 0) + 1);
                    lines[j].put(ch, lines[j].getOrDefault(ch, 0) + 1);
                    boxs[3 * (i / 3) + j / 3].put(ch, boxs[3 * (i / 3) + j / 3].getOrDefault(ch, 0) + 1);
                    if (rows[i].get(ch) > 1 || lines[j].get(ch) > 1 || boxs[3 * (i / 3) + j / 3].get(ch) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
