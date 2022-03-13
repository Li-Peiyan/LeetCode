class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        while(n != 0){
            p = q;
            q = r;
            r = p + q;
            n--;
        }
        return r;
    }
}
