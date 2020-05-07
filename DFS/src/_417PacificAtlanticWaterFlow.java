import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417PacificAtlanticWaterFlow {
    private int m, n;
    private int[][] matrix;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix){
        List<List<Integer>> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0){
            return result;
        }

        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++){
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }

        for (int j = 0; j < n; j++){
            dfs(0, j, canReachP);
            dfs(m - 1, j, canReachA);
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (canReachP[i][j] && canReachA[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] canReach){
        if (canReach[r][c]){
            return;
        }
        canReach[r][c] = true;
        for (int[] d : directions){
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || matrix[r][c] > matrix[nextR][nextC]){
                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }
}
