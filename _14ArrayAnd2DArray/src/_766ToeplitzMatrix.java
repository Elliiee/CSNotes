public class _766ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int expectValue, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if (matrix[row][col] != expectValue) {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }
}
/*
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
 */
