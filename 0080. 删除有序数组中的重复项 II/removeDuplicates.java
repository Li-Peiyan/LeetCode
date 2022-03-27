class Solution {
    public int removeDuplicates(int[] nums) {
        int ad = 0;//数字前进位数
        int len = nums.length;
        int i = 0;
        while(i < len){
            //i位置
            nums[i - ad] = nums[i];
            //i + 1位置
            ++i;
            if(i < len && nums[i] == nums[i - 1]){
                nums[i - ad] = nums[i];
                //后续位置
                ++i;
                while(i < len && nums[i] == nums[i - 1]){
                    ++ad;
                    ++i;
                }
            }
        }
        return len - ad;
    }
}
