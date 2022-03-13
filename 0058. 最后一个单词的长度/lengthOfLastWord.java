class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        while(len >= 0 && s.charAt(len) == ' ')len--;
        if(len == -1)return 0;
        int n = 0;
        while(len >= 0 && s.charAt(len) != ' '){
            ++n;
            len--;
        }
        return n;
    }
}
