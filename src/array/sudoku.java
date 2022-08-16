package array;

//写的代码一定要通俗易懂，不然自己改代码的时候把自己害死了
public class sudoku {
    public static void main(String[] args) {
        char[][] ch = new char[][]{{'8','3','.','.','7','.','.','.','.'}//不要使用char作为变量名，会出现大量错误
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        isValidSudoku(ch);
        System.out.println(isValidSudoku(ch));
    }

    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    public static boolean isValidSudoku(char[][] board) {
        //首先，如何判断数字是不同的？
        //使用hash表（一种数据结构）来判断，在java中可以用数组（具体实现）来实现
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                int curNumber = board[i][j]-'0';
                if(row[i][curNumber]==1){
                    return false;
                }
                if(col[j][curNumber]==1){
                    return false;
                }
                if(box[j/3+(i/3)*3][curNumber]==1){
                    return false;
                }
                row[i][curNumber]=1;
                col[j][curNumber]=1;
                box[j/3+(i/3)*3][curNumber]=1;
            }
        }
        return true;
    }


}
