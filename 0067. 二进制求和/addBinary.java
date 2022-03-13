class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int len = Math.max(lenA, lenB);
        char[] numA = a.toCharArray();
        char[] numB = b.toCharArray();
        int carry = 0;

        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= len; i++){
            if(i <= lenA){
                carry = carry + numA[lenA - i] - '0';
            }else{
                carry += 0;
            }
            if(i <= lenB){
                carry = carry + numB[lenB - i] - '0';
            }else{
                carry += 0;
            }
            builder.append(carry % 2);
            carry /= 2;
        }
        if(carry > 0){
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}
