import java.util.LinkedList;
import java.util.Queue;

public class _542_01Matrix {
    public int[][] updateMatrix(int[][] matrix){
        if (matrix == null || matrix.length == 0)
            return null;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0)
                    queue.offer(new int[] {i, j});
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        while (!queue.isEmpty()){
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];
            for (int[] d : directions){
                int r = row + d[0];
                int c = col + d[1];
                if (r < 0 || c < 0 || r >= m || c >= n || matrix[r][c] <= matrix[row][col] + 1)
                    continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[row][col] + 1;
            }
        }
        return matrix;
    }
}
