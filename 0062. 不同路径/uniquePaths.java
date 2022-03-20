class Solution {
    public int uniquePaths(int m, int n) {
        int[] f = new int[m];
        f[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                f[j] += f[j - 1];
            }
        }
        
        return f[m - 1];
    }
}
