class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []map = new int[128];
        int i;
        for(i=0; i<128; i++)map[i]=-1;
        int start=0;
        int max=0;
        for(i=0; i<s.length(); i++)
        {
            int index = s.charAt(i);
            if( start <= map[index] )start=map[index]+1;
            if( (i-start+1) > max )max = i-start+1;
            map[index]=i;
        }
        return max;
    }
}
