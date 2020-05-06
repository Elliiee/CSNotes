public class _547FriendCircles {
    private int n;

    public int findCircleNum(int[][] M){
        n = M.length;
        int circleNum = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(M, i, visited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] visited){
        visited[i] = true;
        for (int j = 0; j < n; j++){
            if (M[i][j] == 1 && !visited[j]){
                dfs(M, j, visited);
            }
        }
    }
}
