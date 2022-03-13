class Solution { //最佳
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
           for(int j = 0; j < 9; j++){
               if(board[i][j] == '.')continue;
               for(int k = 8; k > j; k--)
                   if(board[i][j] == board[i][k])
                       return false;
               for(int k = 8; k > i; k--)
                   if(board[i][j] == board[k][j])
                       return false;
               for(int k = i + 1; k % 3 != 0; k ++){
                   for(int h = j / 3 * 3;h < j / 3 * 3  + 3; h ++ )
                       if(board[i][j] == board[k][h]) 
                           return false;
               }
           }
       }
       return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];//行
        boolean[][] col = new boolean[9][9];//列
        boolean[][][] block = new boolean[3][3][9];//3*3
        int num;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    num = board[i][j] - '1';
                    if(row[i][num] || col[j][num] || block[ i/3 ][ j/3 ][num] ){
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    block[ i/3 ][ j/3 ][num] = true;    
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];//行
        int[][] col = new int[9][9];//列
        int[][][] block = new int[3][3][9];//3*3
        int num;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    num = board[i][j] - '1';
                    row[i][num]++;
                    col[j][num]++;
                    block[ i/3 ][ j/3 ][num]++;
                    if(row[i][num] > 1 || col[j][num] > 1 || block[ i/3 ][ j/3 ][num] > 1){
                        return false;
                    } 
                }
            }
        }
        return true;
    }
}

