public class _200NumOfIslands {
    private int m, n;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid){
        if (grid == null || grid[0].length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int islandsNum = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] != '0'){
                    dfs(grid, i, j);
                    islandsNum++; // NOte: after the dfs method, otherwise stack overflow or so error
                }
            }
        }
        return islandsNum;
    }

    private void dfs(char[][] grid, int i, int j){
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for (int[] d : directions){
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
