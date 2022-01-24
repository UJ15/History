//dfs문제 재귀로 풀었지만 복잡도가 이게 맞나 싶다. 다른사람의 코드를 참고해보자
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int rsize = grid.length;
        int csize = grid[0].length;
        
        int visit[][] = new int[rsize][csize];
        
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == '1' && visit[i][j] == 0){
                    result++;
                    dfs(i, j, grid, visit);
                }
            }
        }
        
        return result;
        
    }
    
    public void dfs(int i, int j, char[][]grid, int [][] visit){
        visit[i][j] = 1;
        if (i < grid.length - 1 && grid[i + 1][j] ==  '1' && visit[i + 1][j] == 0 ){
            dfs(i + 1, j, grid, visit);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && visit[i][j + 1] == 0){
            dfs(i, j+ 1, grid, visit);
        }
        if (i > 0 && grid[i - 1][j] == '1'&& visit[i-1][j] == 0){
            dfs(i - 1, j, grid, visit);
        }
        if (j > 00 && grid[i][j-1] == '1'&& visit[i][j- 1] == 0){
            dfs(i, j - 1, grid, visit);
        }
    }

}
