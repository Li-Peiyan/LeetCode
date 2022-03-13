class Solution {
    public String convert(String s, int numRows) {
        int n,d,num, l = s.length();
        if(numRows == 1 || l<=numRows)return s;
        n = 2*numRows - 2;
        char[] ls = s.toCharArray();
        StringBuffer str=new StringBuffer();
        for(int i=0; i<numRows; i++)
        {
            d = n -( i % ( numRows-1 ) * 2);
            num = i;
            while(num<l)
            {
                str.append(ls[num]);
                num += d;
                d = n - d%n;
            }
        }
        return str.toString();
    }
}
