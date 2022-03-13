class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
			return 0;
        int i = 0, j = 0;
        for(; j < nums.length; j++,i++){
            while(nums[j] == val){
                j++;
                if(j == nums.length)return i;
            }
            if(i != j)nums[i] = nums[j];
        }
        return i;
    }
}
