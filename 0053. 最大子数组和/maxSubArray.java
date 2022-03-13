class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int add = 0;
        for(int i = 0; i < nums.length; ++i){
            add += nums[i];
            if(add < nums[i])add = nums[i];
            if(add > max) max = add;
        }
        return max;
    }
}
