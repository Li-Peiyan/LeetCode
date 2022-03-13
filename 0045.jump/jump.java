class Solution {
    public int jump(int[] nums) {
        int i, n, max, num = 0;
        i = 0;
        max = 0;
        while(true){
            n = max;
            if( max >= nums.length - 1)return num;
            for(; i <= n; ++i){
                if( (nums[i] + i) > max )max = nums[i] + i;
            }
            ++num;
        }
    }
}
