package backTracking;

public class Exist {
    static boolean b = true;
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));

    }
    public static boolean exist(char[][] board, String word) {
        return dfs(board, word, 0, "");
    }
    public static boolean dfs(char[][] board,String word,int len,String res){
        if(len == word.length()){
            if(res.equals(word)) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char tmp = board[i][j];
                if(isValid(board,word,i,j,len)) {
                    res = res + tmp;
                }
                b = b&&dfs(board,word,len+1,res);
            }
        }
        return b;
    }
    public static boolean isValid(char[][] board,String word,int row,int col,int index){
        if(row+1<board.length&&board[row+1][col]==word.charAt(index)){
            return true;
        }
        if(col+1<board.length&&board[row][col+1]==word.charAt(index)){
            return true;
        }
        if(row-1>=0&&board[row-1][col]==word.charAt(index)){
            return true;
        }
        if(col-1>=0&&board[row][col-1]==word.charAt(index)){
            return true;
        }
        return false;
    }

}
