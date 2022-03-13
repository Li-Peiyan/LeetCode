class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }

        int mid = -1, left = 0, right = nums.length - 1;
        while(left <= right){
            mid = (left + right) >> 1;
            if(nums[mid] == target)break;
            if(target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        if(left > right){
            return new int[]{-1, -1};
        }

        left = mid - 1; right = mid + 1;
        mid = nums[mid];
        while(left > -1 && nums[left] == mid)--left;
        while(right < nums.length && nums[right] == mid)++right;
        return new int[]{left + 1, right - 1};
    }

}
