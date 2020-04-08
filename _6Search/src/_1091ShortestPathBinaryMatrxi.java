import java.util.*;

public class _1091ShortestPathBinaryMatrxi {
    Set<Integer> set = new HashSet<>();
    public int shortestPathBinaryMatrix(int[][] grid){
        int ans = -1;

        if (grid[0][0] == 1)
            return ans;

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> start = new ArrayList<>();

        start.add(0);
        start.add(0);
        start.add(1);

        queue.add(start);
        set.add(0);

        while (!queue.isEmpty()){
            List<Integer> parent = queue.poll();
            int row = parent.get(0);
            int col = parent.get(1);
            int level = parent.get(2);

            if (row == grid.length - 1 && col == grid[0].length - 1)
                return ans;


        }

        return ans;
    }

    public void check(int grid[][], int r, int c, Queue<List<Integer>> queue, int level){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return;

        if (grid[r][c] == 1)
            return;

        int id = r * grid[0].length + c;

        if (!set.contains(id)){
            set.add(id);
            List<Integer> child = new ArrayList<>();
            child.add(r);
            child.add(c);
            child.add(level + 1);
            queue.add(child);
        }
    }

    public int shortestPathBinaryMatrixII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        int[][] directions = {
                {-1, -1},{-1, 0},{-1, 1},{0, -1},{0, 1},{1, -1},{1, 0},{1, 1}
        };

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int pathLength = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while (size-- > 0){
                int[] cur = queue.poll();
                int cr = cur[0], cc = cur[1];
                if (grid[cr][cc] == 1)
                    continue;
                if (cr == m - 1 && cc == n - 1)
                    return pathLength;
                grid[cr][cc] = 1;
                for (int[] d : directions){
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}
