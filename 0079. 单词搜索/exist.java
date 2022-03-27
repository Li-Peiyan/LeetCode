class Solution {
    public boolean exist(char[][] board, String word) {
        char[] word_i = word.toCharArray();
        int len = word_i.length;
        int i, j;//board的位置坐标i、j
        int n = board.length, m = board[0].length;//board的行、列
        boolean[][] bool = new boolean[n][m];//记录board的使用情况
        for(i = 0; i < n; ++i ){
            for(j = 0; j < m; ++j){
                //遍历找到第一个匹配的位置
                if(board[i][j] == word_i[0]){
                    bool[i][j] = true;
                    if( exi(board, word_i, 1, i, j, bool, len, n, m) ){
                        return true;
                    }
                    bool[i][j] = false;
                }
            }
        }
        return false;
    }
    public boolean exi(char[][] board, char[] word_i, int index, int i, int j, boolean[][] bool, int len, int n, int m){
        if(index == len){
            return true;
        }
        //下侧
        if(i + 1 < n && !bool[i + 1][j] && board[i + 1][j] == word_i[index]){
            bool[i + 1][j] = true;
            if( exi(board, word_i, index + 1, i + 1, j, bool, len, n, m) ){
                return true;
            }
            bool[i + 1][j] = false;
        }
        //右侧
        if(j + 1 < m && !bool[i][j + 1] && board[i][j + 1] == word_i[index]){
            bool[i][j + 1] = true;
            if( exi(board, word_i, index + 1, i, j + 1, bool, len, n, m) ){
                return true;
            }
            bool[i][j + 1] = false;
        }
        //上侧
        if(i - 1 >= 0 && !bool[ i-1 ][j] && board[i - 1][j] == word_i[index]){
            bool[ i-1 ][j] = true;
            if( exi(board, word_i, index + 1, i - 1, j, bool, len, n, m) ){
                return true;
            }
            bool[ i-1 ][j] = false;
        }
        //左侧
        if(j - 1 >= 0 && !bool[i][j - 1] && board[i][j - 1] == word_i[index]){
            bool[i][j - 1] = true;
            if( exi(board, word_i, index + 1, i, j - 1, bool, len, n, m) ){
                return true;
            }
            bool[i][j - 1] = false;
        }
        return false;
    }
}
