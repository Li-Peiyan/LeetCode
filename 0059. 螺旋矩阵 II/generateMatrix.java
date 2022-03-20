class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;//上下左右范围
        int num = 1;//对应位置数字
        while (num <= n * n ) {
            //顺时针遍历
            for(int i = left; i <= right; ++i){
                ans[top][i] = num;
                ++num;
            }
            for(int i = top + 1; i <= bottom; ++i){
                ans[i][right] = num;
                ++num;
            }
            if (left < right && top < bottom) {
                for(int i = right - 1; i > left; --i){
                    ans[bottom][i] = num;
                    ++num;
                }
                for(int i = bottom; i > top; --i){
                    ans[i][left] =num;
                    ++num;
                }  
            }
            ++left;
            --right;
            ++top;
            --bottom;
        }
        return ans;
    }
}
