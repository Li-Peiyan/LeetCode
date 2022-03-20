class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        //判断起点不可动，和终点不可达情况
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)return 0;

        int[] f = new int[n];

        f[0] = 1;
        //动态规划
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n - 1];
    }
}
