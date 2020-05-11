import java.util.LinkedList;
import java.util.Queue;

public class _286WallsAndGates {
    /*
    The brute force approach is simple, we just implement a bfs from each empty room to its nearest gate.
     */

    private int empty = Integer.MAX_VALUE;
    private int gate = 0;
    private int wall = -1;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public void wallsAndGates(int[][] rooms){
        if (rooms == null || rooms.length == 0){
            return;
        }
        m = rooms.length;
        n = rooms[0].length;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (rooms[r][c] == empty){
                    rooms[r][c] = bfs(rooms, r, c);
                }
            }
        }
    }

    private int bfs(int[][] rooms, int r, int c){
        m = rooms.length;
        n = rooms[0].length;
        int[][] distance = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        while (!queue.isEmpty()){
            int[] position = queue.poll();
            int row = position[1];
            int col = position[0];
            for (int[] d : directions){
                int cr = row + d[0];
                int cc = col + d[1];
                if (cr < 0 || cc < 0 || cr >= m || cc >= n || rooms[cr][cc] == wall || distance[row][col] != 0){
                    continue;
                }
                distance[cr][cc] = distance[row][col] + 1;
                if (rooms[cr][cc] == gate){
                    return distance[r][c];
                }
                queue.add(new int[] {cr, cc});
            }
        }
        return Integer.MAX_VALUE;
    }

    public void GateToRoom(int[][] rooms){
        if (rooms == null || rooms.length == 0) return;
        m = rooms.length;
        n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (rooms[r][c] == gate){
                    queue.add(new int[] {r, c});
                }
            }
        }
        while (!queue.isEmpty()){
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];
            for (int[] d : directions){
                int r = row + d[0];
                int c = col + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != empty){
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[] {r, c});
            }
        }
    }
}
