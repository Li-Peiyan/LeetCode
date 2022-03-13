class Solution {
    public String reverseWords(String s) {
        if(s.length() <= 1)return s;
        char[] str = s.toCharArray();
        int len = s.length();
        StringBuffer newS = new StringBuffer();
        int j = 0;
        boolean flag = false;
        while(j < len && str[j] == ' ') {
            j++;
        }
        for(int i = j; i < len; i = j){
            while(j < len && str[j] != ' '){
                j++;
            }
            newS.insert(0, s.substring(i, j));
            if(flag){
                newS.insert(j - i , ' ');
            }else{
                flag = true;
            }

            while(j < len && str[j] == ' ') {
                j++;
            }

        }

        return newS.toString();
    
    }
}
