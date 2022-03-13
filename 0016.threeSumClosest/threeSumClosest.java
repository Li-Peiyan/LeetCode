class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3)return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        int left, right, sum, closeDigit = nums[0]+nums[1]+nums[2], sub = Math.abs(target - closeDigit);
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i+1;
            right = nums.length - 1;
            while(left < right)
            {
                sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < sub){
                    closeDigit = sum;
                    sub = Math.abs(target - closeDigit);
                }
                if(sum < target){
                    left++;
                    while(left < right && nums[left] == nums[left - 1])left++;
                }
                else if(sum > target){
                    right--;
                    while(left < right && nums[right] == nums[right + 1])right--;
                }
                else{
                    return target;
                } 
            }
        }
        return closeDigit;
    }
}
