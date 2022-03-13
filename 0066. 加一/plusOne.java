class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        while(len >= 0){
            if(digits[len] != 9){
                digits[len]++;
                return digits;
            }else{
                digits[len] = 0;
                len--;
            }
        }
        //处理原数组都为 9 的情况
        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        return nums;
    }
}
