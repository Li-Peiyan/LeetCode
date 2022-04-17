class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();

        char[] str = s.toCharArray();
        
        int left = 0, right = s.length() - 1;

        while(left < right){

            while(left < right && cherk(str[left])){
                left++;
            }

            while(left < right && cherk(str[right])){
                right--;
            }

            if(str[left] != str[right]){
                return false;
            }

            left++;
            right--;

        }

        return true;

    }
    // 验证是否为 0-9 或 a-z
    public boolean cherk(char c){

        if( ('a' <= c && c <= 'z') || ('0' <= c && c <= '9')){
            return false;
        }
        return true;
    }
}
