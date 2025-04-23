/*Pehle DFS se pehle island ke sabhi 1 ko dhoondh ke queue mein daal diya aur visited mark kar diya.
Ab BFS se queue se expand karte gaye aur har level pe surrounding 0s ko check kiya.
Jab doosre island ka 1 mila, uss waqt tak kitne level BFS chala wo bridge length hai.
Bas, countZero return kar diya jo shortest bridge ka answer hai. 😎*/


class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
           this.row = row;
           this.col = col;
        }
    }
    int n ;
    boolean[][] vis;
    int [][] directions = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
    LinkedList<Pair> queue = new LinkedList<>();
    public void dfs(int [][] grid, int i, int j){
       if(i>=n || i<0 || j>=n || j<0 || vis[i][j] == true || grid[i][j]==0){
          return;
       }
       vis[i][j] = true;
       queue.addLast(new Pair(i, j));
       for(int [] dir : directions){
           int nRow = i + dir[0];
           int nCol = j + dir[1];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && !vis[nRow][nCol]){
              dfs(grid, nRow, nCol);
            }
       }
    }
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        vis = new boolean[n][n];
        boolean flag = false;
        for(int i=0; i<n; i++){
            if(flag) break;
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                   dfs(grid, i, j);
                   flag = true;
                   break;
                }
            }
        }
        return bfs(grid);
    }
    public int bfs(int [][] grid){
        int countZero = 0;
        while(queue.size()>0){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Pair rem = queue.removeFirst();
                for(int [] dir : directions){
                    int nRow = rem.row + dir[0];
                    int nCol = rem.col + dir[1];
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && !vis[nRow][nCol]){
                        if(grid[nRow][nCol] == 0){
                            vis[nRow][nCol] = true;  // mark visited
                            queue.addLast(new Pair(nRow, nCol));
                        } else if(grid[nRow][nCol] == 1){
                            return countZero;
                        }
                    }
                }
            }
            countZero++;
        }
        return countZero;
    }

}
