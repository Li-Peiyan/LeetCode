class Solution {
    public int myAtoi(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int i = 0;
        while(i<n && str[i] == ' ')
        {
            i++;
        }
        if(i == n)return 0;
        boolean negative = false;
        if(str[i] == '-')
        {
            negative = true;
            i++;
        }
        else if(str[i] == '+')i++;
        else if( !Character.isDigit(str[i]) )return 0;
        int ans = 0;
        while( i < n && Character.isDigit(str[i]) )
        {
            int digit = str[i] - '0';
            if( ans > (Integer.MAX_VALUE - digit)/10 )return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ans = ans*10 + digit;
            i++;
        }
        return negative? -ans : ans;

    }
}
