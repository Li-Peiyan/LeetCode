class Solution { // 作弊法
    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        return dividend / divisor;
    }
}


class Solution {
    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; --i) {
            if ( (t>>i) >= d) {//找出足够大的数2^n*divisor
                result += 1<<i;//将结果加上2^n
                t -= d<<i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}



class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)return 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if(divisor == 1)return dividend;
        if(divisor == -1)return -dividend;
        if(dividend == divisor)return 1;
        if(dividend == -divisor)return -1;

        boolean flag = false, check;
        if(dividend > 0){
            dividend = -dividend;
            flag = !flag;
        }
        if(divisor > 0){
            divisor = -divisor;
            flag = !flag;
        }
        if(dividend > divisor)return 0;

        int left = 1, right = Integer.MAX_VALUE, mid, ans = 0;
        while(left <= right){
            mid = left + (( right - left) >> 1 );
            check = quickAdd(divisor, mid, dividend);
            if(check){
                ans = mid;
                if(ans == Integer.MAX_VALUE)break;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return flag? -ans:ans;
    }

    public boolean quickAdd(int y, int z, int x){
        int result = 0, add = y;
        while(z != 0){
            if((z & 1) != 0){
                if(result < x - add){
                    return false;
                }
                result += add;
            }
            if(z != 1){
                if(add < x - add){
                    return false;
                }
                add += add;
            }
            z >>= 1;
        }
        return true;
    }
}
