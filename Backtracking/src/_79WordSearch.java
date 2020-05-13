public class _79WordSearch {
    private int m, n;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null || board.length == 0)
            return false;

        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (backtracking(0, r, c, visited, board, word));
            }
        }
        return false;
    }

    private boolean backtracking(int curLen, int r, int c, boolean[][] visited, char[][] board, String word){
        if (curLen == word.length())
            return true;

        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != word.charAt(curLen) || visited[r][c])
            return false;

        visited[r][c] = true;

        for (int[] d : directions){
            if (backtracking(curLen + 1, r + d[0], c + d[1], visited, board, word))
                return true;
        }

        visited[r][c] = false;

        return false;
    }
}
/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.
 */
