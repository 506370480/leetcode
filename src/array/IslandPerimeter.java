package array;

public class IslandPerimeter {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
    public static int islandPerimeter(int[][] grid) {
        int sumGrid = 0;
        int minus = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    sumGrid+=1;
                    if(i-1>=0&&grid[i-1][j]==1) minus++;
                    if(i+1<grid.length&&grid[i+1][j]==1) minus++;
                    if(j-1>=0&&grid[i][j-1]==1) minus++;
                    if(j+1<grid[0].length&&grid[i][j+1]==1) minus++;
                }
            }
        }
        return sumGrid*4-minus;
    }
}
