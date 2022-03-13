class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)return true;

        int canLen = 1;//最远可到达的长度
    
        for(int i = 0; i < canLen; i++){
            if(i + nums[i] + 1 > canLen){
                canLen = i + nums[i] + 1;
                if(canLen >= nums.length){
                    return true;
                }
            }
        }
        return false;
    }
}
