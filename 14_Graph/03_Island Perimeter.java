/*https://leetcode.com/problems/island-perimeter/submissions/1676870601/*/
class Solution {
    int [][] dir = {{-1,0}, {0,1}, {1,0},{0,-1}};
    int n;
    int m;
    public int islandPerimeter(int[][] grid) {
        n = grid.length; 
        m = grid[0].length;
        
        boolean [][] vis = new boolean [n][m];
        

        for(int i=0; i<n; i++){
            for(int j= 0; j<m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                   return dfs(grid, i, j, vis);
                }
            }
        }
        return 0;
    }
    public int dfs(int [][] grid, int i, int j, boolean[][] vis){
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j] == 0){
           return 1;
        }
        if(vis[i][j]){
            return 0;
        }
        vis[i][j] = true;
        int ans = 0;
        for(int [] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            ans += dfs(grid, ni, nj, vis);
        }
        return ans;
    }
}
