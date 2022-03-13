class Solution { 
    public int romanToInt(String s) {
        int num1,num2=0,n=0,l=s.length();
        if(l == 0)return 0;
        char[] str = s.toCharArray();
        for(; --l>-1;)
        {
           num1 = getDigit(str[l]);
           if(num1 < num2)n -= num1;
           else n += num1;
           num2 = num1;
        }
        return n;
    }
    public static int getDigit(int n)
    {
        switch(n)
        {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
}

