import java.util.LinkedList;
import java.util.Queue;

public class _1091ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid){
        if (grid == null || grid.length == 0){
            return -1;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int pathLength = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while (size-- > 0){
                int[] position = queue.poll();
                int r = position[0];
                int c = position[1];

                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1){
                    continue;
                }

                if (r == m - 1 && c == n - 1){
                    return pathLength;
                }

                grid[r][c] = 1;
                for (int[] d : directions){
                    queue.add(new int[] {r + d[0], c + d[1]});
                }
            }
        }
        return -1;
    }
}
