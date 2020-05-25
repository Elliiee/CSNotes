import java.util.Arrays;

public class _62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for(int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
            for(int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }

    // 1D array DP
    public int uniquePathsII(int m, int n) {
        int[] d = new int[n];

        Arrays.fill(d, 1);

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                d[j] = d[j] + d[j-1];
            }
        }

        return d[n-1];
    }
}
