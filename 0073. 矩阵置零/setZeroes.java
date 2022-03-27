class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length; //行数列数
        boolean[] h = new boolean[m];//行
        boolean[] l = new boolean[n];//列
        for(int i = 0; i < m; ++i){ //遍历读取0的横纵坐标，布尔值记录
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0 && (!h[i] || !l[j])){
                    h[i] = true;
                    l[j] = true;
                }
            }
        }
        int num = 0;//获取需要置0的列号数
        int[] indexL = new int [n];//需要置0的列号
        for(int j = 0; j < n; ++j){//获取需要置0的列号
            if(l[j]){
                indexL[num] = j;
                num++;
            }
        }
        for(int i = 0; i < m; ++i){
            if(h[i]){//行置零则所有列置零
                for(int j = 0; j < n; ++j){
                    matrix[i][j] = 0;
                }
            }else{//行不置0.则对应列置零
                for(int j = 0; j < num; ++j){
                    matrix[i][ indexL[j] ] = 0;
                }
            }
        }
    }
}


