import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _542_01Matrix {
    // brute force
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return matrix;
        int cols = matrix[0].length;
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 0)
                    distance[i][j] = 0;
                else {
                    for (int k = 0; k < rows; k++){
                        for (int l = 0; l < cols; l++){
                            if (matrix[k][l] == 0){
                                int curDistance = Math.abs(k - i) + Math.abs(l - j);
                                distance[i][j] = Math.min(distance[i][j], curDistance);
                            }
                        }
                    }
                }
            }
        }
        return distance;
    }

    // BFS
    public int[][] updateMatrixBFS(int[][] matrix){
        int rows = matrix.length;
        if (rows == 0) return matrix;
        int cols = matrix[0].length;
        int[][] distance = new int[rows][cols];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 0){
                    distance[i][j] = 0;
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] position = queue.poll();
            for (int[] d : directions){
                int r = position[0] + d[0];
                int c = position[1] + d[1];
                if (r >= 0 && c >= 0 && r < rows && c < cols){
                    if (distance[r][c] > distance[position[0]][position[1]] + 1){
                        distance[r][c] = distance[position[0]][position[1]] + 1;
                        queue.add(new int[] {r, c});
                    }
                }
            }
        }
        return distance;
    }
}
