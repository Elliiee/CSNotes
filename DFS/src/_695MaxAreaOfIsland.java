public class _695MaxAreaOfIsland {
    private int rows, cols;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid){
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;
        int area = 1;
        for (int[] d : directions){
            area += dfs(grid, row + d[0], col + d[1]);
        }
        return area;
    }
}
