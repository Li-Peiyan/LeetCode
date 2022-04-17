class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if(i == 0 || i == (m-1)){
                for (int j = 0; j < n; j++) {
                    // 第一行，最后一行
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }else{
                // 第一列
                if (board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
                // 最后一列
                if (board[i][n-1] == 'O') {
                    dfs(board, i, n-1);
                }
            }
            
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了. 
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }
}
