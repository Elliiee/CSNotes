public class _547FriendCircles {
    private static int m;

    public static int findCircleNum(int[][] M){
        if (M == null || M.length == 0)
            return 0;
        m = M.length;
        boolean[] visted = new boolean[m];
        int res = 0;
        for (int i = 0; i < m; i++){
                if (!visted[i]){
                    dfs(M, i, visted);
                    res++;
                }

        }
        return res;
    }

    private static void dfs(int[][] M, int i, boolean[] visited){
        visited[i] = true;
        for (int k = 0; k < m; k++){
            if (M[i][k] == 1 && !visited[k]){
                dfs(M, k, visited);
            }
        }
    }

    public static void main(String[] args){
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int[][] N = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int[][] L = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        int tr = findCircleNum(M);
        int tr2 = findCircleNum(N);
        int tr3 = findCircleNum(L);
        System.out.println(tr);
        System.out.println(tr2);
        System.out.println(tr3);
    }
}
