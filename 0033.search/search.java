class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)return -1;
        if(target == nums[0])return 0;
        if(nums.length < 3){
            if(target == nums[0])return 0;
            if(nums.length == 1 || target != nums[1])return -1;
            return 1;
        } 
        
        int index;
        
        boolean flag;
        if(target < nums[0]){
            flag = false;
            index = nums.length - 1;
        }else{
            flag = true;
            index = 1;
        }
        if(flag){
            while(index < nums.length && nums[index - 1] <= nums[index]){
                if(target == nums[index])return index;
                ++index;
            }
        }else{
            if(target == nums[index])return index;
            else --index;
            while(index > -1 && nums[index] <= nums[index + 1]){
                if(target == nums[index])return index;
                --index;
            }
        }

        return -1;
    }
}
