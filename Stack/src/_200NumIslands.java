public class _200NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0')
            return;

        grid[row][col] = '0';
        for (int[] d : directions){
            int nr = row + d[0];
            int nc = col + d[1];
            dfs(grid, nr, nc);
        }
    }
}
