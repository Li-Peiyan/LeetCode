class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2)return nums.length;
        int i = 1, j = 0;
        for(; i < nums.length; i++){
            if(nums[i] != nums[j])nums[++j] = nums[i];
        }
        return j+1;
    }
}
