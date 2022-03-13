class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2)return s;

        char[] ls = s.toCharArray();

        int[] scope = {0,0};

        for(int i = 0; i < s.length(); i++) 
        {
           i = findPalindrome(ls,i,scope);
        }
        return s.substring(scope[0],scope[1]+1);
    }
    public static int findPalindrome(char[] ls, int start, int[] scope)
    {
        int end = start;
        while (end < ls.length - 1 && ls[end + 1] == ls[start]) {
            end++;
        }
        int ans = end;
      
        while( start > 0 && end < ls.length-1 && ls[start-1] == ls[end+1])
        {
           start--;end++; 
        }
        if( (end - start) > (scope[1] - scope[0]) )
        {
            scope[0] = start;
            scope[1] = end;
        } 
        return ans;
    }
}
