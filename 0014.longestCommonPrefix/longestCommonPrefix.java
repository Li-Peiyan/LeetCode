class Solution { //0ms
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        int len=strs.length;
        for(int n = 1; n<len; n++)
        {  
            int i = 0;
            String str2 = strs[n];
            int length = Math.min(str.length(),str2.length());
            while(i<length && str.charAt(i) == str2.charAt(i))i++;
            str = str.substring(0, i);
            if(str.length() == 0)break;
        }
        return str;
    }
}

class Solution { //1ms
    public String longestCommonPrefix(String[] strs) {
        int i,n=0,len=strs[0].length(),d=strs.length;
        for(;n<len;)
        {  
            
            for(i=1; i<d; )
            {
                if(n>=strs[i].length())break;
                if(strs[0].charAt(n) == strs[i].charAt(n))i++;
                else break;
            }
            if(i==d)n++;
            else break;   
        }
        return strs[0].substring(0,n);
    }
}
