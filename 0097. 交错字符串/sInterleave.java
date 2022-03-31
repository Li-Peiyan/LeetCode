class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }

        char[] ss1=s1.toCharArray();
        char[] ss2=s2.toCharArray();
        char[] ss3=s3.toCharArray();

        boolean[] f = new boolean[m + 1];

        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && ss1[i - 1] == ss3[p];
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && ss2[j - 1] == ss3[p]);
                }
            }
        }

        return f[m];


    }
}
