class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0])return 0;

        int mid = 0, left = 0, right = nums.length - 1;
        while(left <= right){
            mid = (left + right) >> 1;
            if(nums[mid] < target)left = mid + 1;
            else right = mid - 1;
        }
        return nums[mid] < target ? left : mid ;
        
    }
}
