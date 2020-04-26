public class _498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int N = matrix.length, M = matrix[0].length;
        int row = 0, col = 0;
        int direction = 1;
        int[] result = new int[N*M];
        int r = 0;

        while (row < N && col < M){
            result[r++] = matrix[row][col];

            int new_row = row + (direction == 1 ? -1 : 1);
            int new_col = col + (direction == 1 ? 1 : -1);

            if (new_row < 0 || new_row == N || new_col < 0 || new_col == M){
                if (direction == 1){
                    row += (col == M-1 ? 1 : 0);
                    col += (col < M-1 ? 1 : 0);
                }
                else{
                    col += (row == N-1 ? 1 : 0);
                    row += (row < N-1 ? 1 : 0);
                }
                direction = 1 - direction;
            }
            else {
                row = new_row;
                col = new_col;
            }
        }
        return result;
    }
}
